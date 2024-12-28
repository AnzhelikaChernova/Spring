package course.repository;

import course.domain.entity.Lesson;
import course.domain.entity.Teacher;
import course.domain.entity.TeacherLesson;
import course.domain.enums.DayOfWeek;
import course.domain.enums.TimeOfLesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherLessonRepository extends JpaRepository<TeacherLesson, Long> {
    boolean existsByLessonIdAndTeacherId(Long lessonId, Long teacherId);
    Optional<TeacherLesson> findByLessonId(Long id);

    List<TeacherLesson> findByTeacher(Teacher teacher);

    List<TeacherLesson> findByTeacherAndLessonDayOfWeekAndLessonTimeOfLesson(Teacher teacher, DayOfWeek lesson_dayOfWeek, TimeOfLesson lesson_timeOfLesson);

    List<TeacherLesson> findByTeacherId(Long teacherId);
}
