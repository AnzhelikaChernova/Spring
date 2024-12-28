package course.service;

import course.domain.dto.lesson.LessonRequest;
import course.domain.dto.lesson.LessonResponse;
import course.domain.enums.DayOfWeek;
import course.domain.enums.TimeOfLesson;

import java.util.List;

public interface LessonService {
    List<LessonResponse> findAll();

    void save(LessonRequest lessonRequest);

    LessonResponse findById(Long id);

    void update(Long id, LessonRequest updatedLesson);

    void delete(Long id);

    LessonResponse findByCabinetAndDayOfWeekAndTimeOfLesson(
            Integer cabinet,
            DayOfWeek dayOfWeek,
            TimeOfLesson timeOfLesson
    );
}
