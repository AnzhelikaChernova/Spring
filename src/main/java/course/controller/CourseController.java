package course.controller;

import java.util.List;
import javax.validation.Valid;

import course.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;

import course.entity.Course;
import course.service.CourseServiceImpl;

@Controller
public class CourseController {

    @Autowired
    private CourseServiceImpl courseService;

    @GetMapping("courses")
    public String index(Model model) {
        List<Course> courses = courseService.findAllByOrderByNameAsc();
        model.addAttribute("courses", courses);
        return "courses";
    }

    @GetMapping("course/new")
    public String newCourse(Model model) {
        model.addAttribute("course", new Course());
        model.addAttribute("title", "Add Course");
        return "courseForm";
    }

    @GetMapping("course/edit/{id}")
    public String editCourse(@PathVariable("id") Long courseId, Model model) {
        Course course = courseService.findCourseById(courseId);
        if (course == null) {
            throw new ResourceNotFoundException("Course not found with id: " + courseId);
        }
        model.addAttribute("course", course);
        model.addAttribute("title", "Edit Course");
        return "courseForm";
    }

    @PostMapping("saveCourse")
    public String saveCourse(@Valid @ModelAttribute("course") Course course, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Save Course");
            return "courseForm";
        }
        courseService.saveCourse(course);
        return "redirect:/courses";
    }

    @GetMapping("course/delete/{id}")
    public String deleteCourse(@PathVariable("id") Long courseId) {
        Course course = courseService.findCourseById(courseId);
        if (course == null) {
            throw new ResourceNotFoundException("Course not found with id: " + courseId);
        }
        courseService.deleteCourseById(courseId);
        return "redirect:/courses";
    }
}
