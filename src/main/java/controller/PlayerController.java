package controller;

import model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.player.IPlayerService;
import service.type.ITypeService;

//@Component
@RequestMapping("/players")
//@EnableAspectJAutoProxy(proxyTargetClass = true)
@Controller
public class PlayerController {

    @Autowired
    IPlayerService playerService;
    @Autowired
    ITypeService typeService;
    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("/player/home");
        modelAndView.addObject("players",playerService.findAll());
        return modelAndView;
    }

    @GetMapping("/{id}/delete")
    public ModelAndView showFormDelete(@PathVariable long id){
        ModelAndView modelAndView = new ModelAndView("/player/delete");
        modelAndView.addObject("player",playerService.findById(id).get());
        return modelAndView;
    }

    @PostMapping("/{id}/delete")
    public ModelAndView delete(Player player){
        ModelAndView modelAndView = new ModelAndView("/player/home");
        playerService.delete(player.getId());
        modelAndView.addObject("players",playerService.findAll());
        return modelAndView;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditForm(@PathVariable long id){
        ModelAndView modelAndView = new ModelAndView("/player/edit");
        modelAndView.addObject("player",playerService.findById(id).get());
        modelAndView.addObject("types",typeService.findAll());
        return modelAndView;
    }

    @PostMapping("/{id}/edit")
    public ModelAndView edit(Player player){
        ModelAndView modelAndView = new ModelAndView("/player/home");
        playerService.save(player);
        modelAndView.addObject("players",playerService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView = new ModelAndView("/player/create");
        modelAndView.addObject("types",typeService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView save(Player player){
        ModelAndView modelAndView = new ModelAndView("/player/home");
        playerService.save(player);
        modelAndView.addObject("players",playerService.findAll());
        return modelAndView;
    }
}
