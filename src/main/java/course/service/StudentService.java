package course.service;

import course.domain.dto.student.StudentEditRequest;
import course.domain.dto.student.StudentRequest;
import course.domain.dto.student.StudentResponse;

import java.util.List;

public interface StudentService {
    List<StudentResponse> findAll();

    void save(StudentRequest student);

    StudentResponse findById(Long id);

    void update(Long id, StudentEditRequest updatedStudent);

    void delete(Long id);
}
