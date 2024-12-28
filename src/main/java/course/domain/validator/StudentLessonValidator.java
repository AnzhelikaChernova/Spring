package course.domain.validator;

import course.domain.dto.student.StudentLessonValidation;
import course.domain.entity.StudentLesson;
import course.repository.LessonRepository;
import course.repository.StudentLessonRepository;
import course.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StudentLessonValidator implements Validator {

    private final StudentLessonRepository studentLessonRepository;
    private final StudentRepository studentRepository;
    private final LessonRepository lessonRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return StudentLessonValidation.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        StudentLessonValidation studentLessonValidation = (StudentLessonValidation) target;

        if (studentLessonRepository.existsByLessonIdAndStudentId(
                studentLessonValidation.getLessonId(),
                studentLessonValidation.getStudentId()
        )) {
            errors.rejectValue(
                    "lessonId",
                    "error.lessonexists",
                    "Student already registered"
            );
        }

        var lesson = lessonRepository.findById(studentLessonValidation.getLessonId()).orElse(null);

        if (lesson != null) {
            List<StudentLesson> existingLessons = studentLessonRepository.findByStudentId(studentLessonValidation.getStudentId());
            for (StudentLesson studentLesson : existingLessons) {
                if (studentLesson.getLesson().getDayOfWeek() == lesson.getDayOfWeek() &&
                        studentLesson.getLesson().getTimeOfLesson() == lesson.getTimeOfLesson()) {
                    errors.rejectValue(
                            "lessonId",
                            "errors.alreadyexists",
                            "Student is already registered for a lesson at this time."
                    );
                }
            }
            long registeredStudents = studentLessonRepository.countByLessonId(studentLessonValidation.getLessonId());
            if (registeredStudents >= lesson.getStudentCount()) {
                errors.rejectValue(
                        "lessonId",
                        "errors.fullcount",
                        "Предмет переполнен"
                );
            }
        }

    }
}
