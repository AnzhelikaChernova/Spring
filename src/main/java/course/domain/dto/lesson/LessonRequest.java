package course.domain.dto.lesson;

import course.domain.enums.Course;
import course.domain.enums.DayOfWeek;
import course.domain.enums.Department;
import course.domain.enums.TimeOfLesson;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LessonRequest {

    private Long id;

    @NotBlank(message = "Название пусток")
    private String name;

    private Department department;

    private DayOfWeek dayOfWeek;

    private TimeOfLesson timeOfLesson;

    private Course course;

    @Range(min = 0, max = 25)
    private Integer studentCount;

    @Positive
    private Integer cabinet;

    private boolean isDeleted;
}
