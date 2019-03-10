package self.he.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;

@Controller
@RequestMapping("/li")
public class LiController {
    @RequestMapping("/li")
    public String li(Model model){
        model.addAttribute("model","Li");
        return "bye";
    }

    @RequestMapping(value = {"/he"},method = RequestMethod.GET)
    public  String he(Model model){
        model.addAttribute("model","He");
        return "bye";
    }
    @RequestMapping(path = {"/m1?"})
    public String m1(){
        System.out.println("m1..............");
        return "forward";
    }
}
