package self.he.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import self.he.pojo.User;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {


    @RequestMapping("/login")
    public String login(User user, HttpSession session){

        if(user != null&& user.getName()!= null && user.getName().equals("好")){
            //(数据库检查)
            System.out.println(user.getName());
            session.setAttribute("SESSION_USER",user);
            return "user";
        }
        System.out.println("....login...........");
        return "redirect:/login.jsp";
    }

    @RequestMapping("/delete")
    public String delete(){
        System.out.println("....可以为所欲为了delete...........");
        return "user";
    }
}
