package course.service;

import course.domain.dto.lesson.LessonResponse;
import course.domain.dto.teacher.TeacherEditRequest;
import course.domain.dto.teacher.TeacherRequest;
import course.domain.dto.teacher.TeacherResponse;
import course.domain.dto.teacher.TeacherScheduleResponse;
import course.domain.enums.Department;

import java.util.List;

public interface TeacherService {

    List<TeacherResponse> findAll();

    void save(TeacherRequest teacher);

    TeacherResponse findById(Long id);

    void update(Long id, TeacherEditRequest updatedTeacher);

    void delete(Long id);

    List<TeacherResponse> findAllByDepartment(Department department);
}
