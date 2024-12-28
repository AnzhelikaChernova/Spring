package course.domain.validator;

import course.domain.dto.lesson.TeacherLessonValidation;
import course.domain.entity.TeacherLesson;
import course.repository.LessonRepository;
import course.repository.TeacherLessonRepository;
import course.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TeacherLessonValidator implements Validator {
    private final TeacherLessonRepository teacherLessonRepository;
    private final TeacherRepository teacherRepository;
    private final LessonRepository lessonRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return TeacherLessonValidation.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        TeacherLessonValidation teacherLessonValidation = (TeacherLessonValidation) target;

        if (teacherLessonRepository.existsByLessonIdAndTeacherId(
                teacherLessonValidation.getLessonId(),
                teacherLessonValidation.getTeacherId()
        )) {
            errors.rejectValue(
                    "lessonId",
                    "error.lessonexists",
                    "Lesson already exists"
            );
        }

        var teacher = teacherRepository.findById(teacherLessonValidation.getTeacherId()).orElse(null);
        var lesson = lessonRepository.findById(teacherLessonValidation.getLessonId()).orElse(null);
        List<TeacherLesson> existingLessons = null;
        if (teacher != null && lesson != null){
            existingLessons = teacherLessonRepository.findByTeacherAndLessonDayOfWeekAndLessonTimeOfLesson(
                    teacher, lesson.getDayOfWeek(), lesson.getTimeOfLesson()
            );

            for (TeacherLesson existingLesson : existingLessons) {
                if (!existingLesson.getLesson().getCabinet().equals(lesson.getCabinet())) {
                    errors.rejectValue(
                            "lessonId",
                            "errors.timeexists",
                            "Teacher already has a lesson at this time in a different cabinet."
                    );
                }
            }
        }
    }
}
