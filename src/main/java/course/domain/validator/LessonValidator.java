package course.domain.validator;

import course.domain.dto.lesson.LessonRequest;
import course.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class LessonValidator implements Validator {

    private final LessonService lessonService;

    @Override
    public boolean supports(Class<?> clazz) {
        return LessonRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LessonRequest lessonRequest = (LessonRequest) target;

        var lessonResponse = lessonService.findByCabinetAndDayOfWeekAndTimeOfLesson(
                lessonRequest.getCabinet(),
                lessonRequest.getDayOfWeek(),
                lessonRequest.getTimeOfLesson()
        );
        if (lessonResponse != null && !Objects.equals(lessonRequest.getId(), lessonResponse.getId())) {
            errors.rejectValue(
                    "cabinet",
                    "errors.cabinetmatch",
                    "Кабинет занят в этот день в это время"
            );
        }
    }
}
