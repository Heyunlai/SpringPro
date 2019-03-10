package self.he.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import self.he.pojo.People;


@Controller
@RequestMapping("/people2")
@SessionAttributes("people")
public class People2Controller {
    //在controller里任意一个方法执行前执行
//    @ModelAttribute
//    public People init(){
//        System.out.println("init........");
//        People people = new People();
//        people.setName("Li");
//        return people;
//    }

    @ModelAttribute("people")
    public void init(Model model){
        System.out.println("init........");
        People people = new People();
        people.setName("Li");
        model.addAttribute("people",people);
    }

    @RequestMapping("/login")
    public String login(Model model){
        System.out.println(model.containsAttribute("people"));
        return "forward";
    }

    @RequestMapping("/login2")
    public String login2(@ModelAttribute People people){
        System.out.println(people.getName());
        return "login";
    }
    @RequestMapping("/login3")
    public String login3(@ModelAttribute People people){
        System.out.println(people.getName());
        return "redirect:/jsp/login.jsp";
    }

}
