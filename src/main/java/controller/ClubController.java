package controller;

import model.Club;
import model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.club.IClubService;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Controller
public class ClubController {
    @Value("${fileUpload}")
    private String fileUpload;

    @Autowired
    private IClubService clubService;

    @GetMapping("/club/home")
    public ModelAndView home(Model model) {
        Iterable<Club> clubs = clubService.findAll();
        model.addAttribute("clubs", clubs);
        ModelAndView modelAndView = new ModelAndView("/club/home");
        return modelAndView;
    }

    @GetMapping("/club/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("/club/create");
        modelAndView.addObject("club", new Club());
        return modelAndView;
    }

    @PostMapping("/club/create")
    public String create(@ModelAttribute Club club, @RequestParam("fileImage") MultipartFile multipartFile) {
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        club.setLogo(fileName);
        clubService.save(club);
        return "redirect:/club/home";
    }

    @GetMapping("/club/{id}/edit")
    public ModelAndView edit(@PathVariable Long id) {
        Optional<Club> club = clubService.findById(id);
        if (club.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/club/edit");
            modelAndView.addObject("club", club.get());
            return modelAndView;
        } else {
            return new ModelAndView("/club/home");
        }
    }

    @PostMapping("/club/update")
    public String update(Club club, @RequestParam("fileImage") MultipartFile multipartFile) {
        if (multipartFile.getOriginalFilename() != "") {
            String fileName = multipartFile.getOriginalFilename();
            try {
                FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload + fileName));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            club.setLogo(fileName);
            clubService.save(club);
        } else {
            Club club1 = clubService.findById(club.getId()).get();
            club.setLogo(club1.getLogo());
            clubService.save(club);
        }
        return "redirect:/club/home";
    }

    @GetMapping("/club/{id}/delete")
    public String delete(@PathVariable Long id, Model model) {
        model.addAttribute("club", clubService.findById(id));
        return "/club/delete";
    }

    @PostMapping("/club/delete")
    public String delete(Club club, RedirectAttributes redirect) {
        clubService.delete(club.getId());
        redirect.addFlashAttribute("success", "Removed club successfully!");
        return "redirect:/club/home";
    }

    @GetMapping("/club/search")
    public ModelAndView findByName(@RequestParam("search") String name) {
        Iterable<Club> clubs = clubService.findByName(name);
        ModelAndView modelAndView = new ModelAndView("/club/home");
        modelAndView.addObject("clubs", clubs);
        return modelAndView;
    }

}
