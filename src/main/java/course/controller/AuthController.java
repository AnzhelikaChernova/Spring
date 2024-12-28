package course.controller;

import course.domain.dto.auth.LoginRequest;
import course.domain.dto.auth.SignUpRequest;
import course.domain.validator.LoginValidator;
import course.domain.validator.SignUpValidator;
import course.service.AuthService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final SignUpValidator signUpValidator;
    private final LoginValidator loginValidator;

    @GetMapping(value = "signup")
    public String signup(Model model) {
        model.addAttribute("signup", new SignUpRequest());
        return "signup";
    }

    @PostMapping("signup")
    public String signup(
            @Valid @ModelAttribute("signup") SignUpRequest signUpRequest,
            BindingResult bindingResult,
            RedirectAttributes redirAttrs
    ) {
        signUpValidator.validate(signUpRequest, bindingResult);

        if (!bindingResult.hasErrors()) {
            authService.signUp(signUpRequest);
            redirAttrs.addFlashAttribute("message", "User registered successfully!");
            return "redirect:/login";
        }

        return "signup";
    }

    @GetMapping("login")
    public String showLoginForm(Model model) {
        model.addAttribute("login", new LoginRequest());
        return "login";
    }

    @PostMapping("login")
    public String login(
            @Valid @ModelAttribute("login") LoginRequest loginRequest,
            HttpServletResponse response,
            BindingResult bindingResult
    ) {
        loginValidator.validate(loginRequest, bindingResult);

        if (!bindingResult.hasErrors()) {
            var token = authService.login(loginRequest);
            ResponseCookie jwtCookie = ResponseCookie.from("jwt", token)
                    .httpOnly(true)
                    .secure(false)
                    .path("/")
                    .maxAge(7 * 24 * 60 * 60)
                    .build();
            response.addHeader("Set-Cookie", jwtCookie.toString());
            return "redirect:/";
        }

        return "login";
    }

    @PostMapping("/logout")
    public String logout(){

        return "login";
    }

}
