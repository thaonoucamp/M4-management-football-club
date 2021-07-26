package controller;

import model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.coach.ICoachService;
import service.player.IPlayerService;

import java.io.File;
import java.io.IOException;

@Component
@RequestMapping("/players")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class PlayerController {

    @Autowired
    ICoachService coachService;
    @Autowired
    IPlayerService playerService;

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        System.out.println("Controller");
        ModelAndView modelAndView = new ModelAndView("/player/create");
        modelAndView.addObject("countries", playerService.findAll()); // ném cho view 1 list country để tý còn làm xe nếch óp xừn
        return modelAndView;
    }

    @GetMapping("")
    public ModelAndView showList(@PageableDefault(size = 6) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/player/list");
        modelAndView.addObject("cities", coachService.findAll(pageable));
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView showOne(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/player/view");
        modelAndView.addObject("player", coachService.findById(id).get());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(Player player, @RequestParam MultipartFile file, BindingResult result) throws IOException {
            System.out.println(result);
            String fileName = file.getOriginalFilename();
            FileCopyUtils.copy(file.getBytes(),
                    new File("/Users/abc/Downloads/image/" + fileName));
            player.setImage(fileName);
//        coachService.save(player);
            return "redirect:/cities";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showFormEdit(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/player/edit");
        modelAndView.addObject("countries", playerService.findAll());
        modelAndView.addObject("player", coachService.findById(id).get());
        return modelAndView;
    }

    @PostMapping("/{id}/edit")
    public String saveEdit(@PathVariable Long id, Player player, @RequestParam MultipartFile file, BindingResult result) {
        System.out.println(result);
        String fileName = file.getOriginalFilename();
        try {
            FileCopyUtils.copy(file.getBytes(),
                    new File("/Users/abc/Downloads/image/" + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        player.setId(id);
        if (fileName.equals("") == false) {
            player.setImage(fileName);
        } else {
            player.setImage(coachService.findById(id).get().getImage());
        }
//        coachService.save(player);
        return "redirect:/cities";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        coachService.delete(id);
        return "redirect:/cities";
    }

    @GetMapping("/search")
    public ModelAndView findByName(String name) {
        ModelAndView modelAndView = new ModelAndView("/player/list");
        modelAndView.addObject("cities", coachService.findAllByName("%" + name + "%"));
        return modelAndView;
    }

}
