package course.service;

import course.domain.dto.auth.LoginRequest;
import course.domain.dto.auth.SignUpRequest;
import course.domain.dto.auth.UserResponse;

public interface AuthService {

    void signUp(SignUpRequest signUpRequest);

    String login(LoginRequest loginRequest);

    UserResponse getAuthenticatedUser();
}
