package course.service;

import course.domain.dto.lesson.LessonResponse;
import course.domain.dto.lesson.LessonTeacherResponse;
import course.domain.dto.teacher.TeacherResponse;
import course.domain.dto.teacher.TeacherScheduleResponse;

import java.util.List;

public interface TeacherLessonService {
    void assignTeacher(Long id, Long teacherId);

    TeacherResponse findByLessonId(Long id);

    TeacherScheduleResponse getTeacherSchedule(Long teacherId);

    List<LessonResponse> findLessonsByTeacherId(Long teacherId);

    List<LessonTeacherResponse> findAll();
}
