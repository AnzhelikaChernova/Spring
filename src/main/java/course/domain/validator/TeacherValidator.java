package course.domain.validator;

import course.domain.dto.teacher.TeacherRequest;
import course.repository.TeacherRepository;
import course.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class TeacherValidator implements Validator {
    private final UserRepository userRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return TeacherRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        TeacherRequest teacherRequest = (TeacherRequest) target;

        if (!teacherRequest.getPassword().equals(teacherRequest.getPasswordCheck()))
            errors.rejectValue(
                    "passwordCheck",
                    "error.pwdmatch",
                    "Passwords does not match"
            );

        if (userRepository.findByEmail(teacherRequest.getEmail()).isPresent())
            errors.rejectValue(
                    "email",
                    "error.userexists",
                    "User with this email already exists"
            );
    }
}
