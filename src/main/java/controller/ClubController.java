package controller;

import model.Club;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.club.IClubService;

@Controller
public class ClubController {
//
//    @Autowired
//    private IClubService clubService;
//
//    @GetMapping("/create")
//    public ModelAndView showFormCreate(){
//        ModelAndView modelAndView = new ModelAndView("/club/create");
//        return modelAndView;
//    }
//
//    @PostMapping("/create")
//    public ModelAndView create(Club club){
//        clubService.save(club);
//        ModelAndView modelAndView = new ModelAndView("/club/home");
//        return modelAndView;
//    }
//
//    @PostMapping("/save")
//    public String save(Club club) {
//        clubService.save(club);
//        return "redirect:/club/home";
//    }
//
//    @GetMapping("/{id}/edit")
//    public String edit(@PathVariable Long id, Model model) {
//        model.addAttribute("club", clubService.findById(id));
//        return "/club/edit";
//    }
//
//    @PostMapping("/update")
//    public String update(Club club) {
//        clubService.save(club);
//        return "redirect:/club/home";
//    }
//
//    @GetMapping("/{id}/delete")
//    public String delete(@PathVariable Long id, Model model) {
//        model.addAttribute("club", clubService.findById(id));
//        return "/club/delete";
//    }
//
//    @PostMapping("/delete")
//    public String delete(Club club, RedirectAttributes redirect) {
//        clubService.delete(club.getId());
//        redirect.addFlashAttribute("success", "Removed club successfully!");
//        return "redirect:/club/home";
//    }
//
//    @GetMapping("/{id}/view")
//    public String view(@PathVariable Long id, Model model) {
//        model.addAttribute("club", clubService.findById(id));
//        return "/club/view";
//    }
//
//    @GetMapping("/search")
//    public String findByName(@RequestParam String name, Model model){
//        model.addAttribute("club", clubService.findByName(name));
//        return "/club/home";
//    }

}
