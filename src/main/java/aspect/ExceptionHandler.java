package aspect;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ModelAndView exception(Exception ex){
        System.out.println(ex.getMessage());
        ModelAndView modelAndView = new ModelAndView("/error");
        return modelAndView;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(IllegalArgumentException.class)
    public ModelAndView exception2(Exception ex){
        System.out.println(ex.getMessage());
        ModelAndView modelAndView = new ModelAndView("/error2");
        return modelAndView;
    }
}
