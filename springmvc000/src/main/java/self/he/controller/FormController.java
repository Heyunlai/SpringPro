package self.he.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/he")
public class FormController {
    @GetMapping(path = {"/m1"})
    public String m1(Model model){
        model.addAttribute("model","m1 get");
        System.out.println("m1..............");
        return "forward";
    }

    @PostMapping(path = {"/m1"})
    public String m2(Model model){
        model.addAttribute("model","m1 post");
        System.out.println("m1..............");
        return "forward";
    }

    @DeleteMapping(path = {"/m1"})
    public String m3(Model model){
        model.addAttribute("model","m1 post Delete");
        System.out.println("m1..............");
        return "forward";
    }

}
