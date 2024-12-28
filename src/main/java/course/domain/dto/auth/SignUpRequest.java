package course.domain.dto.auth;

import course.domain.enums.Department;
import course.domain.enums.Grade;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SignUpRequest {

    @Email(message = "Неверная почта")
    @NotBlank(message = "Email пуст")
    private String email;

    @NotBlank(message = "Пароль пуст")
    private String password;

    @NotBlank(message = "Повторите пароль")
    private String passwordCheck;

    @NotBlank(message = "Заполните имя")
    private String firstname;

    @NotBlank(message = "Заполните фамилию")
    private String lastname;

    private Grade grade;

    private Department department;
}
