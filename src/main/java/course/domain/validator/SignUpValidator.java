package course.domain.validator;

import course.domain.dto.auth.SignUpRequest;
import course.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class SignUpValidator implements Validator {

    private final UserRepository userRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return SignUpRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SignUpRequest signUpRequest = (SignUpRequest) target;

        if (!signUpRequest.getPassword().equals(signUpRequest.getPasswordCheck()))
            errors.rejectValue(
                    "passwordCheck",
                    "error.pwdmatch",
                    "Passwords does not match"
            );

        if (userRepository.findByEmail(signUpRequest.getEmail()).isPresent())
            errors.rejectValue(
                    "email",
                    "error.userexists",
                    "User with this email already exists"
            );
    }
}