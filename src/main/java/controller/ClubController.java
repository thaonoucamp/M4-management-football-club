package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.club.IClubService;

@Controller
public class ClubController {

    @Autowired
    private IClubService clubService;

    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView = new ModelAndView("/club/view");
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(){
        ModelAndView modelAndView = new ModelAndView("/club/view");
        return modelAndView;
    }



}
