package self.she.service;

import org.springframework.stereotype.Component;

@Component
public class HelloService {
    public void hello(String name,String sex){
        System.out.println("hello "+name+"!"+sex+"!!!");
    }
    public String eat(){
        System.out.println("eating!!!!");
        return "Li";
    }
}
