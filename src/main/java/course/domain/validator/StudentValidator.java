package course.domain.validator;

import course.domain.dto.student.StudentRequest;
import course.repository.StudentRepository;
import course.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class StudentValidator implements Validator {

    private final UserRepository userRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return StudentRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        StudentRequest studentRequest = (StudentRequest) target;

        if (!studentRequest.getPassword().equals(studentRequest.getPasswordCheck()))
            errors.rejectValue(
                    "passwordCheck",
                    "error.pwdmatch",
                    "Passwords does not match"
            );

        if (userRepository.findByEmail(studentRequest.getEmail()).isPresent())
            errors.rejectValue(
                    "email",
                    "error.userexists",
                    "User with this email already exists"
            );
    }
}
