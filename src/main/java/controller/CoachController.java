package controller;

import model.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.coach.ICoachService;

@Controller
@RequestMapping("/coaches")
public class CoachController {

    @Autowired
    ICoachService coachService;

    @GetMapping("/create")
    public String showFormCreate() {
        return "/coach/create";
    }
    @GetMapping("")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("/coach/list");
        modelAndView.addObject("coaches", coachService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public String saveNew(Coach coach) {
        coachService.save(coach);
        return "redirect:/coaches";
    }

}
