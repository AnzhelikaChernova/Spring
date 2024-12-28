package course.domain.dto.lesson;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherLessonValidation {
    private Long lessonId;
    private Long teacherId;
}
