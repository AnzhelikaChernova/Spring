package course.domain.dto.teacher;

import course.domain.dto.lesson.LessonResponse;
import course.domain.enums.DayOfWeek;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherScheduleResponse {

    private Long teacherId;
    private TeacherResponse teacher;
    private List<DayScheduleDTO> schedule;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DayScheduleDTO {
        private DayOfWeek dayOfWeek;
        private List<LessonResponse> lessons;
    }
}

