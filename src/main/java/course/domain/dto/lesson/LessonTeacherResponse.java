package course.domain.dto.lesson;

import course.domain.dto.teacher.TeacherResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LessonTeacherResponse {

    private LessonResponse lesson;

    private TeacherResponse teacher;
}
