package course;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import course.domain.entity.Student;
import course.repository.StudentRepository;
import course.repository.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UniversityApplicationTests {

}
