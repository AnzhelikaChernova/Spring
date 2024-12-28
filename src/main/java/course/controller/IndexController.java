package course.controller;

import course.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final AuthService authService;

    @ModelAttribute
    public void addAuthenticatedUserToModel(Model model) {
        var userResponse = authService.getAuthenticatedUser();
        model.addAttribute("user", userResponse);
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
