package course.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import course.domain.dto.auth.LoginRequest;
import course.domain.dto.auth.SignUpRequest;
import course.domain.dto.auth.UserResponse;
import course.domain.entity.Student;
import course.domain.enums.Course;
import course.domain.enums.UserRole;
import course.repository.UserRepository;
import course.security.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class DefaultAuthService implements AuthService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final ObjectMapper objectMapper;

    @Override
    public void signUp(SignUpRequest signUpRequest) {

        var student = objectMapper.convertValue(signUpRequest, Student.class);
        student.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        student.setRole(UserRole.STUDENT);
        student.setCourse(Course.FIRST);
        student.setCreatedAt(LocalDateTime.now());
        student.setDeleted(false);

        userRepository.save(student);
    }

    @Override
    public String login(LoginRequest loginRequest) {
        return jwtUtil.createToken(authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
        ));
    }

    @Override
    public UserResponse getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        var userResponse = new UserResponse();

        if (authentication != null && authentication.isAuthenticated()) {

            userResponse = objectMapper.convertValue(
                    userRepository.findByEmail(authentication.getName()),
                    UserResponse.class
            );
        }

        return userResponse;
    }
}
