package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.user.IUserService;

@Controller
@SessionAttributes("user")
@RequestMapping("/users")
public class UserController {
    @Autowired
    IUserService userService;

    @ModelAttribute("user")
    public User setUpUser() {
        return new User();
    }

    @GetMapping("/goTo")
    public String goTo(@ModelAttribute("user") User user) {
        if(user.getRolee().equals("coach")){
            return "redirect:/players/home";
        }else {
            return "redirect:/types/list";
        }


    }


    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("/user/login");
        return modelAndView;
    }

    @PostMapping("/home")
    public String checkLogin(@ModelAttribute("user") User user, Model model, @RequestParam String username, String password) {
        User user1 = userService.findByUserName(username).get();
        if (user1.getPassword().equals(password) && user1.getUsername().equals(username)) {
            user.setId(user1.getId());
            user.setUsername(user1.getUsername());
            user.setPassword(user1.getPassword());
            user.setRolee(user1.getRolee());
            return "redirect:/users/goTo";
        } else {
            return "redirect:/users/login";
        }
    }


}
