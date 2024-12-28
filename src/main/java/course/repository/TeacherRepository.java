package course.repository;

import course.domain.entity.Teacher;
import course.domain.enums.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Optional<Teacher> findByEmail(String email);
    @Query("select t from Teacher t where t.department = :department and t.isDeleted = false")
    List<Teacher> findAllByDepartment(Department department);
}
