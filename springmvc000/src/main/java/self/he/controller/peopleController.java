package self.he.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import self.he.pojo.People;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/people")
public class peopleController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }


    @RequestMapping("/add/{name}/{sex}")
    public String addPeople(@PathVariable("name") String name,@PathVariable("sex")String sex){
        System.out.println(name+":"+sex);
        return "forward";
    }

    @PutMapping("/put")
    @ResponseBody//需要额外的json包的支持
    public String putPeople(People people){
        System.out.println(people.getName()+":"+people.getSex());
        return "ok";
    }

    @PostMapping("/date")
    @ResponseBody//需要额外的json包的支持
    public String postPeople(People people){
        System.out.println("hhhh");
        System.out.println(people.getDate());
        return "ok";
    }

}
