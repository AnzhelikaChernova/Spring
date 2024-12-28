package course.domain.validator;

import course.domain.dto.auth.LoginRequest;
import course.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class LoginValidator implements Validator {

    private final AuthService authService;

    @Override
    public boolean supports(Class<?> clazz) {
        return LoginRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LoginRequest loginRequest = (LoginRequest) target;

        try {
            authService.login(loginRequest);
        } catch (BadCredentialsException e) {
            errors.rejectValue(
                    "password",
                    "Invalid.credentials",
                    "Invalid username or password"
            );
        } catch (Exception e) {
            errors.reject("auth.error", "An error occurred during authentication");
        }
    }
}

