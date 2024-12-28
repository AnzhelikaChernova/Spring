package course.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import course.domain.dto.lesson.LessonResponse;
import course.domain.dto.lesson.LessonTeacherResponse;
import course.domain.dto.student.StudentResponse;
import course.domain.dto.student.StudentScheduleResponse;
import course.domain.dto.teacher.TeacherResponse;
import course.domain.entity.*;
import course.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DefaultStudentLessonService implements StudentLessonService{

    private final StudentRepository studentRepository;
    private final LessonRepository lessonRepository;
    private final StudentLessonRepository studentLessonRepository;
    private final TeacherLessonRepository teacherLessonRepository;
    private final ObjectMapper objectMapper;

    @Transactional
    @Override
    public void registerForLesson(Long studentId, Long lessonId) {
        var student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));
        var lesson = lessonRepository.findById(lessonId)
                .orElseThrow(() -> new IllegalArgumentException("Lesson not found"));

        StudentLesson studentLesson = new StudentLesson();
        studentLesson.setStudent(student);
        studentLesson.setLesson(lesson);

        studentLessonRepository.save(studentLesson);
    }

    public StudentScheduleResponse getStudentSchedule(Long studentId) {
        List<StudentLesson> studentLessons = studentLessonRepository.findByStudentId(studentId);
        var student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));
        var studentResponse = objectMapper.convertValue(student, StudentResponse.class);

        List<StudentScheduleResponse.DayScheduleDTO> schedule = studentLessons.stream()
                .map(StudentLesson::getLesson)
                .collect(Collectors.groupingBy(Lesson::getDayOfWeek))
                .entrySet().stream()
                .map(entry -> new StudentScheduleResponse.DayScheduleDTO(entry.getKey(),
                        entry.getValue().stream()
                                .map(this::convertLessonToLessonWithTeacherResponse)
                                .collect(Collectors.toList())))
                .collect(Collectors.toList());

        return new StudentScheduleResponse(
                studentResponse,
                schedule
        );
    }

    public List<StudentScheduleResponse.LessonWithTeacherResponse> getLessonsForStudent(Long studentId) {
        List<StudentLesson> studentLessons = studentLessonRepository.findByStudentId(studentId);

        return studentLessons.stream()
                .map(studentLesson -> {
                    Lesson lesson = studentLesson.getLesson();
                    TeacherLesson teacherLesson = teacherLessonRepository.findByLessonId(lesson.getId()).orElse(null);
                    Teacher teacher = null;
                    if (teacherLesson != null) {
                        teacher = teacherLesson.getTeacher();
                    }
                    TeacherResponse teacherResponse = objectMapper.convertValue(teacher, TeacherResponse.class);
                    LessonResponse lessonResponse = objectMapper.convertValue(lesson, LessonResponse.class);
                    return new StudentScheduleResponse.LessonWithTeacherResponse(lessonResponse, teacherResponse);
                })
                .collect(Collectors.toList());
    }

    private StudentScheduleResponse.LessonWithTeacherResponse convertLessonToLessonWithTeacherResponse(Lesson lesson) {
        var teacherLesson = teacherLessonRepository.findByLessonId(lesson.getId()).orElse(null);
        var teacher = teacherLesson != null ? teacherLesson.getTeacher() : null;
        var teacherResponse = objectMapper.convertValue(teacher, TeacherResponse.class);
        var lessonResponse = objectMapper.convertValue(lesson, LessonResponse.class);

        return new StudentScheduleResponse.LessonWithTeacherResponse(lessonResponse, teacherResponse);
    }
}
