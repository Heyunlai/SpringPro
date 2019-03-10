package self.he.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import self.he.pojo.People;

import java.util.Date;

@Controller
@RequestMapping("/xml")
public class XmlController {

    @RequestMapping(value = "/m1",produces ={MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public People m1(){
        People people = new People();
        people.setName("Lily");
        people.setSex("girl");
        people.setDate(new Date());
        return people;
    }
}
