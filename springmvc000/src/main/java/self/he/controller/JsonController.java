package self.he.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import self.he.pojo.People;

import java.util.Date;

@Controller
@RequestMapping("/json")
public class JsonController {

    //向前台发送json
    @RequestMapping("/m1")
    @ResponseBody
    public People m1(){
        People people = new People();
        people.setName("Li");
        people.setSex("girl");
        people.setDate(new Date());
        return people;
    }

    @RequestMapping("/m2")
    @ResponseBody
    public People m1(@RequestBody People people){
        System.out.println(people.getName());
        People people1 = new People();
        people1.setName("Li");
        people1.setSex("girl");
        people1.setDate(new Date());
        return people1;
    }
}
