package course.repository;

import course.domain.entity.Lesson;
import course.domain.enums.DayOfWeek;
import course.domain.enums.TimeOfLesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
    Optional<Lesson> findByCabinetAndDayOfWeekAndTimeOfLesson(
            Integer cabinet,
            DayOfWeek dayOfWeek,
            TimeOfLesson timeOfLesson
    );
}

