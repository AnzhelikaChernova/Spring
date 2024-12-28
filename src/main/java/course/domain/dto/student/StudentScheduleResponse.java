package course.domain.dto.student;

import course.domain.dto.teacher.TeacherResponse;
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
public class StudentScheduleResponse {

    private StudentResponse student;
    private List<DayScheduleDTO> schedule;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DayScheduleDTO {
        private DayOfWeek dayOfWeek;
        private List<LessonWithTeacherResponse> lessons;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LessonWithTeacherResponse {
        private LessonResponse lesson;
        private TeacherResponse teacher;
    }
}
