package controller;

import model.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.coach.ICoachService;

@Controller
@RequestMapping("/coaches")
public class CoachController {
 @Autowired
     private ICoachService coachService;
    @GetMapping("/list")
    public String showList(Model model){
        Iterable<Coach> coaches= coachService.findAll();
        model.addAttribute("coaches",coaches);
        return "/coach/list";
    }
    @GetMapping("/{id}/delete")
    public ModelAndView showFormDelete(@PathVariable long id){
        ModelAndView modelAndView = new ModelAndView("/coach/delete");
        modelAndView.addObject("coach",coachService.findById(id).get());
        return modelAndView;
    }
    @PostMapping("/{id}/delete")
    public ModelAndView delete(Coach coach){
        ModelAndView modelAndView = new ModelAndView("/coach/list");
        coachService.delete(coach.getId());
        modelAndView.addObject("coaches",coachService.findAll());
        return modelAndView;
    }
    @GetMapping("/{id}/edit")
    public ModelAndView showEditForm(@PathVariable long id){
        ModelAndView modelAndView = new ModelAndView("/coach/edit");
        modelAndView.addObject("coach",coachService.findById(id).get());
        return modelAndView;
    }
    @PostMapping("/{id}/edit")
    public ModelAndView edit(Coach coach){
        ModelAndView modelAndView = new ModelAndView("/coach/list");
        coachService.save(coach);
        modelAndView.addObject("coaches",coachService.findAll());
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView = new ModelAndView("/coach/create");
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView save(Coach coach){
        ModelAndView modelAndView = new ModelAndView("/coach/list");
        coachService.save(coach);
        modelAndView.addObject("coaches",coachService.findAll());
        return modelAndView;
    }
    @GetMapping("/search")
    public ModelAndView search(@RequestParam("search")String search){
        Iterable<Coach>coaches = coachService.findAllByName("%"+search+"%");
        ModelAndView modelAndView= new ModelAndView("/coach/list");
        modelAndView.addObject("coaches",coaches);
        return modelAndView;
    }


}
