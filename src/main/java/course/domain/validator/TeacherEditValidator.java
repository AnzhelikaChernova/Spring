package course.domain.validator;

import course.domain.dto.teacher.TeacherEditRequest;
import course.domain.exception.ResourceNotFoundException;
import course.repository.TeacherRepository;
import course.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class TeacherEditValidator implements Validator {

    private final UserRepository userRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return TeacherEditRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        TeacherEditRequest teacherEditRequest = (TeacherEditRequest) target;
        var updatableUser = userRepository
                .findByEmail(teacherEditRequest.getEmail())
                .orElse(null);

        if (updatableUser!=null&& !Objects.equals(teacherEditRequest.getId(), updatableUser.getId()))
            errors.rejectValue(
                    "email",
                    "error.userexists",
                    "User with this email already exists"
            );
    }
}
