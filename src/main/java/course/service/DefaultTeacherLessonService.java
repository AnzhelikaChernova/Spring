package course.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import course.domain.dto.lesson.LessonResponse;
import course.domain.dto.lesson.LessonTeacherResponse;
import course.domain.dto.teacher.TeacherResponse;
import course.domain.dto.teacher.TeacherScheduleResponse;
import course.domain.entity.Lesson;
import course.domain.entity.Teacher;
import course.domain.entity.TeacherLesson;
import course.domain.exception.ResourceNotFoundException;
import course.repository.LessonRepository;
import course.repository.TeacherLessonRepository;
import course.repository.TeacherRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DefaultTeacherLessonService implements TeacherLessonService {

    private final TeacherRepository teacherRepository;
    private final LessonRepository lessonRepository;
    private final TeacherLessonRepository teacherLessonRepository;
    private final ObjectMapper objectMapper;

    @Override
    @Transactional
    public void assignTeacher(Long id, Long teacherId) {
        TeacherLesson teacherLesson = new TeacherLesson();

        var lesson = lessonRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lesson not found"));

        var teacher = teacherRepository
                .findById(teacherId)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found"));

        var existingTeacherLesson = teacherLessonRepository.findByLessonId(id).orElse(null);
        if (existingTeacherLesson != null) {
            existingTeacherLesson.setTeacher(teacher);
            teacherLessonRepository.save(existingTeacherLesson);
        } else {
            teacherLesson.setLesson(lesson);
            teacherLesson.setTeacher(teacher);

            teacherLessonRepository.save(teacherLesson);
        }
    }

    @Override
    public TeacherResponse findByLessonId(Long id) {
        var teacherLesson = teacherLessonRepository
                .findByLessonId(id)
                .orElse(null);
        Teacher teacher = null;
        if (teacherLesson != null) {
            teacher = teacherLesson.getTeacher();
        }
        return objectMapper.convertValue(teacher, TeacherResponse.class);
    }

    @Override
    public TeacherScheduleResponse getTeacherSchedule(Long teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found"));

        List<TeacherLesson> teacherLessons = teacherLessonRepository.findByTeacher(teacher);

        List<TeacherScheduleResponse.DayScheduleDTO> schedule = teacherLessons.stream()
                .map(TeacherLesson::getLesson)
                .collect(Collectors.groupingBy(Lesson::getDayOfWeek))
                .entrySet().stream()
                .map(entry -> new TeacherScheduleResponse.DayScheduleDTO(entry.getKey(),
                        entry.getValue().stream()
                                .map(this::convertLessonToResponse)
                                .collect(Collectors.toList())))
                .collect(Collectors.toList());

        return new TeacherScheduleResponse(
                teacher.getId(),
                objectMapper.convertValue(teacher, TeacherResponse.class),
                schedule
        );
    }

    @Override
    public List<LessonResponse> findLessonsByTeacherId(Long teacherId) {
        List<TeacherLesson> teacherLessons = teacherLessonRepository.findByTeacherId(teacherId);

        return teacherLessons.stream()
                .map(teacherLesson -> {
                    Lesson lesson = teacherLesson.getLesson();
                    return objectMapper.convertValue(lesson, LessonResponse.class);
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<LessonTeacherResponse> findAll() {
        return teacherLessonRepository
                .findAll()
                .stream()
                .map(teacherLesson -> {
                    var teacher = teacherLesson.getTeacher();
                    var lesson = teacherLesson.getLesson();
                    var teacherResponse = objectMapper.convertValue(teacher, TeacherResponse.class);
                    var lessonResponse = objectMapper.convertValue(lesson, LessonResponse.class);
                    return new LessonTeacherResponse(lessonResponse, teacherResponse);
                })
                .toList();
    }

    private LessonResponse convertLessonToResponse(Lesson lesson) {
        return objectMapper.convertValue(lesson, LessonResponse.class);
    }
}
