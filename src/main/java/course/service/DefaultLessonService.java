package course.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import course.domain.dto.lesson.LessonRequest;
import course.domain.dto.lesson.LessonResponse;
import course.domain.entity.Lesson;
import course.domain.entity.TeacherLesson;
import course.domain.enums.DayOfWeek;
import course.domain.enums.TimeOfLesson;
import course.domain.exception.ResourceNotFoundException;
import course.repository.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultLessonService implements LessonService {

    private final LessonRepository lessonRepository;
    private final PasswordEncoder passwordEncoder;
    private final ObjectMapper objectMapper;

    @Override
    public List<LessonResponse> findAll() {
        return lessonRepository
                .findAll()
                .stream()
                .map(lesson -> objectMapper.convertValue(lesson, LessonResponse.class))
                .toList();
    }

    @Override
    public void save(LessonRequest lessonRequest) {
        var lesson = objectMapper.convertValue(lessonRequest, Lesson.class);

        lesson.setCreatedAt(LocalDateTime.now());
        lesson.setDeleted(false);

        lessonRepository.save(lesson);
    }

    @Override
    public LessonResponse findById(Long id) {
        return objectMapper.convertValue(getById(id), LessonResponse.class);
    }

    @Override
    public void update(Long id, LessonRequest updatedLesson) {
        var lesson = getById(id);
        lesson.setId(id);
        lesson.setCabinet(updatedLesson.getCabinet());
        lesson.setName(updatedLesson.getName());
        lesson.setTimeOfLesson(updatedLesson.getTimeOfLesson());
        lesson.setDayOfWeek(updatedLesson.getDayOfWeek());
        lesson.setStudentCount(updatedLesson.getStudentCount());
        lesson.setCourse(updatedLesson.getCourse());
        lesson.setDepartment(updatedLesson.getDepartment());
        lesson.setDeleted(updatedLesson.isDeleted());
        lessonRepository.save(lesson);
    }

    @Override
    public void delete(Long id) {
        Lesson lesson = getById(id);
        lesson.setDeleted(true);
        lessonRepository.save(lesson);
    }

    @Override
    public LessonResponse findByCabinetAndDayOfWeekAndTimeOfLesson(Integer cabinet, DayOfWeek dayOfWeek, TimeOfLesson timeOfLesson) {
        var lesson = lessonRepository
                .findByCabinetAndDayOfWeekAndTimeOfLesson(cabinet, dayOfWeek, timeOfLesson)
                .orElse(null);
        return objectMapper.convertValue(lesson, LessonResponse.class);
    }

    private Lesson getById(Long id) {
        return lessonRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Lesson not found"));
    }

}
