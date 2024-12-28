package course.controller;

import course.domain.dto.teacher.TeacherScheduleResponse;
import course.domain.entity.Teacher;
import course.service.AuthService;
import course.service.DefaultTeacherLessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final DefaultTeacherLessonService teacherLessonService;
    private final AuthService authService;

    @GetMapping("schedule")
    public String getTeacherSchedule(Model model) {
        var teacher = authService.getAuthenticatedUser();
        TeacherScheduleResponse schedule = teacherLessonService.getTeacherSchedule(teacher.getId());

        model.addAttribute("schedule", schedule);
        return "teachers/schedule";
    }

    @GetMapping("/lessons")
    public String getLessonsByTeacher(Model model) {
        var teacher = authService.getAuthenticatedUser();
        model.addAttribute("lessons", teacherLessonService.findLessonsByTeacherId(teacher.getId()));
        return "teachers/lessons";
    }
}
