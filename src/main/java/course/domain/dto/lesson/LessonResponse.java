package course.domain.dto.lesson;

import course.domain.enums.Course;
import course.domain.enums.DayOfWeek;
import course.domain.enums.Department;
import course.domain.enums.TimeOfLesson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LessonResponse {

    private Long id;
    private String name;
    private Department department;
    private DayOfWeek dayOfWeek;
    private TimeOfLesson timeOfLesson;
    private Course course;
    private Integer studentCount;
    private Integer cabinet;
    private LocalDateTime createdAt;
    private boolean isDeleted;
}
