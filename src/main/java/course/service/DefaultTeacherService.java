package course.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import course.domain.dto.lesson.LessonResponse;
import course.domain.dto.teacher.TeacherEditRequest;
import course.domain.dto.teacher.TeacherRequest;
import course.domain.dto.teacher.TeacherResponse;
import course.domain.dto.teacher.TeacherScheduleResponse;
import course.domain.entity.Lesson;
import course.domain.entity.Teacher;
import course.domain.entity.TeacherLesson;
import course.domain.enums.Department;
import course.domain.enums.UserRole;
import course.domain.exception.ResourceNotFoundException;
import course.repository.LessonRepository;
import course.repository.TeacherLessonRepository;
import course.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DefaultTeacherService implements TeacherService {

    private final PasswordEncoder passwordEncoder;
    private final TeacherRepository teacherRepository;
    private final ObjectMapper objectMapper;

    @Override
    public List<TeacherResponse> findAll() {
        return teacherRepository
                .findAll()
                .stream()
                .map(teacher -> objectMapper.convertValue(teacher, TeacherResponse.class))
                .toList();
    }

    @Override
    public void save(TeacherRequest teacherRequest) {
        var teacher = objectMapper.convertValue(teacherRequest, Teacher.class);
        teacher.setPassword(passwordEncoder.encode(teacher.getPassword()));
        teacher.setRole(UserRole.TEACHER);
        teacher.setCreatedAt(LocalDateTime.now());
        teacher.setDeleted(false);

        teacherRepository.save(teacher);
    }

    @Override
    public TeacherResponse findById(Long id) {
        return objectMapper.convertValue(getById(id), TeacherResponse.class);
    }

    @Override
    public void update(Long id, TeacherEditRequest updatedTeacher) {
        var teacher = getById(id);
        teacher.setId(id);
        teacher.setFirstname(updatedTeacher.getFirstname());
        teacher.setLastname(updatedTeacher.getLastname());
        teacher.setGrade(updatedTeacher.getGrade());
        teacher.setDepartment(updatedTeacher.getDepartment());
        teacher.setEmail(updatedTeacher.getEmail());
        teacher.setDeleted(updatedTeacher.isDeleted());
        teacherRepository.save(teacher);
    }

    @Override
    public void delete(Long id) {
        Teacher teacher = getById(id);
        teacher.setDeleted(true);
        teacherRepository.save(teacher);
    }

    @Override
    public List<TeacherResponse> findAllByDepartment(Department department) {
        return teacherRepository
                .findAllByDepartment(department)
                .stream()
                .map(teacher -> objectMapper.convertValue(teacher, TeacherResponse.class))
                .toList();
    }

    private Teacher getById(Long id) {
        return teacherRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Teacher not found"));
    }
}
