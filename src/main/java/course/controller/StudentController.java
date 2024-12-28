package course.controller;

import course.domain.dto.student.StudentLessonValidation;
import course.domain.dto.student.StudentScheduleResponse;
import course.domain.validator.StudentLessonValidator;
import course.service.AuthService;
import course.service.StudentLessonService;
import course.service.TeacherLessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("student")
public class StudentController {
    private final StudentLessonService studentLessonService;
    private final TeacherLessonService teacherLessonService;
    private final AuthService authService;
    private final StudentLessonValidator studentLessonValidator;

    @GetMapping("register")
    public String showRegistrationForm(Model model) {
        var student = authService.getAuthenticatedUser();
        StudentLessonValidation studentLessonValidation = new StudentLessonValidation();
        studentLessonValidation.setStudentId(student.getId());  // Устанавливаем studentId

        model.addAttribute("studentLessonValidation", studentLessonValidation);
        model.addAttribute("lessons", teacherLessonService.findAll());
        model.addAttribute("student", student);
        return "students/register";
    }

    @PostMapping("register")
    public String registerStudent(
            @ModelAttribute("studentLessonValidation") StudentLessonValidation studentLessonValidation,
            BindingResult bindingResult,
            Model model) {

        studentLessonValidator.validate(studentLessonValidation, bindingResult);

        var student = authService.getAuthenticatedUser();

        if (bindingResult.hasErrors()) {
            model.addAttribute("lessons", teacherLessonService.findAll());
            model.addAttribute("student", student);
            return "students/register";
        }

        studentLessonService.registerForLesson(
                student.getId(),
                studentLessonValidation.getLessonId()
        );

        return "redirect:/student/schedule";
    }

    @GetMapping("schedule")
    public String getStudentSchedule(Model model) {
        var student = authService.getAuthenticatedUser();
        StudentScheduleResponse schedule = studentLessonService.getStudentSchedule(student.getId());

        model.addAttribute("schedule", schedule);
        return "students/schedule";
    }

    @GetMapping("lessons")
    public String getLessonsForStudent(Model model) {
        var student = authService.getAuthenticatedUser();
        model.addAttribute("lessons", studentLessonService.getLessonsForStudent(student.getId()));
        return "students/lessons";
    }
}

