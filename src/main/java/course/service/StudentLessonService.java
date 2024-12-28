package course.service;

import course.domain.dto.student.StudentScheduleResponse;

import java.util.List;

public interface StudentLessonService {
    void registerForLesson(Long studentId, Long lessonId);

    StudentScheduleResponse getStudentSchedule(Long id);

    List<StudentScheduleResponse.LessonWithTeacherResponse> getLessonsForStudent(Long id);
}
