package course.controller;

import course.domain.dto.lesson.LessonRequest;
import course.domain.dto.lesson.LessonResponse;
import course.domain.dto.lesson.TeacherLessonValidation;
import course.domain.dto.student.StudentEditRequest;
import course.domain.dto.student.StudentRequest;
import course.domain.dto.teacher.TeacherEditRequest;
import course.domain.dto.teacher.TeacherRequest;
import course.domain.validator.*;
import course.service.LessonService;
import course.service.StudentService;
import course.service.TeacherLessonService;
import course.service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("admin")
public class AdminController {

    private final TeacherService teacherService;
    private final StudentService studentService;
    private final LessonService lessonService;
    private final TeacherLessonService teacherLessonService;
    private final TeacherValidator teacherValidator;
    private final TeacherEditValidator teacherEditValidator;
    private final StudentValidator studentValidator;
    private final StudentEditValidator studentEditValidator;
    private final TeacherLessonValidator teacherLessonValidator;
    private final LessonValidator  lessonValidator;

    @GetMapping("teachers")
    public String teachers(Model model) {
        model.addAttribute("teachers", teacherService.findAll());
        return "teachers/teachers";
    }

    @GetMapping("teachers/new")
    public String showTeacherAddForm(Model model) {
        model.addAttribute("teacherRequest", new TeacherRequest());
        return "teachers/add";
    }

    @PostMapping("teachers")
    public String addTeacher(
            @Valid @ModelAttribute("teacherRequest") TeacherRequest teacherRequest,
            BindingResult bindingResult
    ) {
        teacherValidator.validate(teacherRequest, bindingResult);

        if (bindingResult.hasErrors()) {
            return "teachers/add";
        }

        teacherService.save(teacherRequest);

        return "redirect:/admin/teachers";
    }

    @GetMapping("teachers/{id}")
    public String showTeacherEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("teacherEdit", teacherService.findById(id));
        return "teachers/edit";
    }

    @PostMapping("teachers/{id}")
    public String updateTeacher(
            @PathVariable Long id,
            @Valid @ModelAttribute("teacherEdit") TeacherEditRequest updatedTeacher,
            BindingResult bindingResult
    ) {
        teacherEditValidator.validate(updatedTeacher, bindingResult);

        if (bindingResult.hasErrors()) {
            return "teachers/edit";
        }

        teacherService.update(id, updatedTeacher);
        return "redirect:/admin/teachers";
    }

    @PostMapping("teachers/delete/{id}")
    public String deleteTeacher(@PathVariable Long id) {
        teacherService.delete(id);
        return "redirect:/admin/teachers";
    }

    @GetMapping("students")
    public String students(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "students/students";
    }

    @GetMapping("students/new")
    public String showStudentAddForm(Model model) {
        model.addAttribute("studentRequest", new StudentRequest());
        return "students/add";
    }

    @PostMapping("students")
    public String addStudent(
            @Valid @ModelAttribute("studentRequest") StudentRequest studentRequest,
            BindingResult bindingResult
    ) {
        studentValidator.validate(studentRequest, bindingResult);

        if (bindingResult.hasErrors()) {
            return "students/add";
        }

        studentService.save(studentRequest);

        return "redirect:/admin/students";
    }

    @GetMapping("students/{id}")
    public String showStudentEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("studentEdit", studentService.findById(id));
        return "students/edit";
    }

    @PostMapping("students/{id}")
    public String updateStudent(
            @PathVariable Long id,
            @Valid @ModelAttribute("studentEdit") StudentEditRequest updatedStudent,
            BindingResult bindingResult
    ) {
        studentEditValidator.validate(updatedStudent, bindingResult);

        if (bindingResult.hasErrors()) {
            return "students/edit";
        }

        studentService.update(id, updatedStudent);
        return "redirect:/admin/students";
    }

    @PostMapping("students/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.delete(id);
        return "redirect:/admin/students";
    }

    @GetMapping("lessons")
    public String lessons(Model model) {
        model.addAttribute("lessons", lessonService.findAll());
        return "lessons/lessons";
    }

    @GetMapping("lessons/new")
    public String showLessonAddForm(Model model) {
        model.addAttribute("lesson", new LessonRequest());
        return "lessons/add";
    }

    @PostMapping("lessons")
    public String addLesson(
            @Valid @ModelAttribute("lesson") LessonRequest lessonRequest,
            BindingResult bindingResult
    ) {
        lessonValidator.validate(lessonRequest, bindingResult);

        if (bindingResult.hasErrors()) {
            return "lessons/add";
        }

        lessonService.save(lessonRequest);

        return "redirect:/admin/lessons";
    }

    @GetMapping("lessons/{id}")
    public String showLessonEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("lesson", lessonService.findById(id));
        return "lessons/edit";
    }

    @PostMapping("lessons/{id}")
    public String updateLesson(
            @PathVariable Long id,
            @Valid @ModelAttribute("lesson") LessonRequest updatedLesson,
            BindingResult bindingResult
    ) {
        lessonValidator.validate(updatedLesson, bindingResult);

        if (bindingResult.hasErrors()) {
            return "lessons/edit";
        }

        lessonService.update(id, updatedLesson);
        return "redirect:/admin/lessons";
    }

    @PostMapping("lessons/delete/{id}")
    public String deleteLesson(@PathVariable Long id) {
        lessonService.delete(id);
        return "redirect:/admin/lessons";
    }

    @GetMapping("lessons/{id}/assign-teacher")
    public String showAssignTeacherForm(@PathVariable Long id, Model model) {
        LessonResponse lessonResponse = lessonService.findById(id);
        var teachers = teacherService.findAllByDepartment(lessonResponse.getDepartment());
        var assignedTeacher = teacherLessonService.findByLessonId(id);
        model.addAttribute("lesson", lessonResponse);
        model.addAttribute("teachers", teachers);
        model.addAttribute("assignedTeacher", assignedTeacher);
        model.addAttribute(
                "teacherLesson",
                new TeacherLessonValidation(lessonResponse.getId(), null)
        );
        return "lessons/assign-teacher";
    }

    @PostMapping("lessons/assign-teacher")
    public String assignTeacher(
            @Valid @ModelAttribute("teacherLesson") TeacherLessonValidation teacherLessonValidation,
            BindingResult bindingResult,
            Model model
    ) {
        teacherLessonValidator.validate(teacherLessonValidation, bindingResult);
        if (!bindingResult.hasErrors()) {
            teacherLessonService.assignTeacher(
                    teacherLessonValidation.getLessonId(),
                    teacherLessonValidation.getTeacherId());
            return "redirect:/admin/lessons";
        }
        LessonResponse lessonResponse = lessonService.findById(teacherLessonValidation.getLessonId());
        var teachers = teacherService.findAllByDepartment(lessonResponse.getDepartment());
        var assignedTeacher = teacherLessonService.findByLessonId(lessonResponse.getId());
        model.addAttribute("lesson", lessonResponse);
        model.addAttribute("teachers", teachers);
        model.addAttribute("assignedTeacher", assignedTeacher);
        return "lessons/assign-teacher";
    }

}
