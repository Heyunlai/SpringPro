package self.he.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import self.he.pojo.People;

import javax.servlet.http.HttpSession;
import javax.xml.ws.RequestWrapper;
import java.util.ArrayList;
import java.util.List;

@Controller//不需要继承任何类
@RequestMapping("/bye")
public class ByeController {

   @RequestMapping("/bye")
    public String bye(Model model){
       model.addAttribute("model","Li");
       // return的是ViewName
       //此时去的/jsp/bye.jsp
       return "bye";
    }

    @RequestMapping("/goodBye")
    public String goodBye(Model model){
        model.addAttribute("model","Lily");
        return "bye";
    }

    @RequestMapping("/byeBye")
    public String byeBye(Model model){
        List<People> list = new ArrayList<>();
        People p1 = new People();
        p1.setName("Li");
        p1.setSex("girl");
        People p2 = new People();
        p2.setName("He");
        p2.setSex("boy");
        list.add(p1);
        list.add(p2);
        model.addAttribute("model",list);
        return "byeBye";
    }
    @RequestMapping("/redirect")
    public String redirect(Model model){
        model.addAttribute("model","hello");
        return "redirect:/jsp/redirect.jsp";
    }

//    模拟请求
    @RequestMapping("/request")
    public String request(WebRequest request){
        System.out.println(request.getParameter("girl"));
        return "forward:/li/li";
    }
    @RequestMapping("/request1")
    public String redirect2(HttpSession session){
       session.setAttribute("session","LLLi");
       session.getServletContext().setAttribute("ctx1","持久lll");
        return "redirect:/jsp/redirect.jsp";
    }

}
