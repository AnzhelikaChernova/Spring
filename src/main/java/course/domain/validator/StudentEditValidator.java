package course.domain.validator;


import course.domain.dto.student.StudentEditRequest;
import course.domain.exception.ResourceNotFoundException;
import course.repository.StudentRepository;
import course.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class StudentEditValidator implements Validator {

    private final UserRepository userRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return StudentEditRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        StudentEditRequest studentEditRequest = (StudentEditRequest) target;
        var updatableUser = userRepository
                .findByEmail(studentEditRequest.getEmail())
                .orElse(null);

        if (updatableUser != null && !Objects.equals(studentEditRequest.getId(), updatableUser.getId()))
            errors.rejectValue(
                    "email",
                    "error.userexists",
                    "User with this email already exists"
            );
    }
}
