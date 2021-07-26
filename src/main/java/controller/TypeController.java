package controller;

import model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.type.TypeService;

import java.util.Optional;

@Controller
@RequestMapping("/types")
public class TypeController {
    @Autowired
    private TypeService typeService;
@GetMapping("/list")
    public String showList(Model model){
    Iterable<Type>types=typeService.findAll();
    model.addAttribute("types",types);
    return "/type/list";
}
@GetMapping("/create")
    public String showCreateForm(Model model){
    model.addAttribute("type",new Type());
    return "/type/create";
}
@GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
    Optional<Type>type=typeService.findById(id);
    if (type.isPresent()){
        ModelAndView modelAndView = new ModelAndView("/type/edit");
        modelAndView.addObject("type",type.get());
        return modelAndView;
    }else {
        return new ModelAndView("/type/list");
    }
}
@GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id){
    Optional<Type>type=typeService.findById(id);
    if (type.isPresent()){
        ModelAndView modelAndView = new ModelAndView("/type/delete");
        modelAndView.addObject("type",type.get());
        return modelAndView;
    }else {
        return new ModelAndView("/type/list");
    }
}
@GetMapping("/search")
    public ModelAndView search(@RequestParam("search")String search){
    Iterable<Type>types=typeService.findByName("%"+search+"%");
    ModelAndView modelAndView= new ModelAndView("/type/list");
    modelAndView.addObject("types",types);
    return modelAndView;
}
@PostMapping("/create")
    public String create(@ModelAttribute("type")Type type,Model model){
    typeService.save(type);
    model.addAttribute("type",new Type());
    return "redirect:list";
}
@PostMapping("/edit")
    public String edit(@ModelAttribute("type")Type type,Model model){
    typeService.save(type);
    model.addAttribute("type",new Type());
    return "redirect:list";
}
@PostMapping("delete")
    public String delete(@ModelAttribute("type")Type type,Model model){
    typeService.delete(type.getId());
    model.addAttribute("type",new Type());
    return "redirect:list";
}
}
