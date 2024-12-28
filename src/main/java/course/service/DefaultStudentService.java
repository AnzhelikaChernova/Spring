package course.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import course.domain.dto.student.StudentResponse;
import course.domain.dto.student.StudentEditRequest;
import course.domain.dto.student.StudentRequest;
import course.domain.dto.student.StudentResponse;
import course.domain.entity.Student;
import course.domain.enums.UserRole;
import course.domain.exception.ResourceNotFoundException;
import course.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultStudentService implements StudentService {

    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;
    private final ObjectMapper objectMapper;

    @Override
    public List<StudentResponse> findAll() {
        return studentRepository
                .findAll()
                .stream()
                .map(student -> objectMapper.convertValue(student, StudentResponse.class))
                .toList();
    }

    @Override
    public void save(StudentRequest studentRequest) {
        var student = objectMapper.convertValue(studentRequest, Student.class);
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        student.setRole(UserRole.TEACHER);
        student.setCreatedAt(LocalDateTime.now());
        student.setDeleted(false);

        studentRepository.save(student);
    }

    @Override
    public StudentResponse findById(Long id) {
        return objectMapper.convertValue(getById(id), StudentResponse.class);
    }

    @Override
    public void update(Long id, StudentEditRequest updatedStudent) {
        var student = getById(id);
        student.setId(id);
        student.setFirstname(updatedStudent.getFirstname());
        student.setLastname(updatedStudent.getLastname());
        student.setGrade(updatedStudent.getGrade());
        student.setCourse(updatedStudent.getCourse());
        student.setDepartment(updatedStudent.getDepartment());
        student.setEmail(updatedStudent.getEmail());
        student.setDeleted(updatedStudent.isDeleted());
        studentRepository.save(student);
    }

    @Override
    public void delete(Long id) {
        Student student = getById(id);
        student.setDeleted(true);
        studentRepository.save(student);
    }

    private Student getById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found"));
    }
}
