package course.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ModelAndView handleResourceNotFoundException(ResourceNotFoundException ex, Model model) {
        ModelAndView modelAndView = new ModelAndView("error"); // укажите имя шаблона для страницы ошибок
        modelAndView.addObject("message", ex.getMessage());
        return modelAndView;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleGenericException(Exception ex, Model model) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("message", "An unexpected error occurred: " + ex.getMessage());
        return modelAndView;
    }
}
