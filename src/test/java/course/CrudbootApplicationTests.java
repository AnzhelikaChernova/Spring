package course;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import course.entity.Student;
import course.entity.User;
import course.repository.StudentRepository;
import course.repository.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CrudbootApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void addStudent() {
        Student student = new Student("Test", "Student", "IT", "test@test.com");

        studentRepository.save(student);

        Optional<Student> findStudent = studentRepository.findById(student.getId());

        assertTrue(findStudent.isPresent());

        Student savedStudent = findStudent.orElseThrow();
        assertEquals("Test", savedStudent.getFirstName());
        assertEquals("Student", savedStudent.getLastName());
        assertEquals("IT", savedStudent.getDepartment());
        assertEquals("test@test.com", savedStudent.getEmail());
    }
}
