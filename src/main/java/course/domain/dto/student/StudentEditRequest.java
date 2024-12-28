package course.domain.dto.student;

import course.domain.enums.Course;
import course.domain.enums.Department;
import course.domain.enums.Grade;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentEditRequest {

    private Long id;

    @Email(message = "Неверная почта")
    @NotBlank(message = "Email пуст")
    private String email;

    @NotBlank(message = "Заполните имя")
    private String firstname;

    @NotBlank(message = "Заполните фамилию")
    private String lastname;

    private Course course;

    private Grade grade;

    private Department department;

    private boolean isDeleted;
}
