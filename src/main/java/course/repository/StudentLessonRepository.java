package course.repository;

import course.domain.entity.Student;
import course.domain.entity.StudentLesson;
import course.domain.entity.Teacher;
import course.domain.entity.TeacherLesson;
import course.domain.enums.DayOfWeek;
import course.domain.enums.TimeOfLesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentLessonRepository extends JpaRepository<StudentLesson, Long> {
    List<StudentLesson> findByStudentId(Long studentId);

    boolean existsByLessonIdAndStudentId(Long lessonId, Long studentId);

    long countByLessonId(Long lessonId);

    Optional<StudentLesson> findByLessonId(Long id);

    List<StudentLesson> findByStudent(Student student);

    List<StudentLesson> findByStudentAndLessonDayOfWeekAndLessonTimeOfLesson(
            Student student,
            DayOfWeek lesson_dayOfWeek,
            TimeOfLesson lesson_timeOfLesson
    );
}
