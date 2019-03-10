package self.she;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import self.she.config.SpringConfig;
import self.she.service.HelloService;


public class TestAop {
    @Test
    public void m2(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/applicationContext1.xml");

        HelloService helloService = ctx.getBean("helloService", HelloService.class);
        helloService.hello("Li","girl");
        helloService.eat();
    }

    @Test
    public void  m1(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        Girl girl = ctx.getBean("girl",Girl.class);
        System.out.println(girl.getName());
        System.out.println(girl.getBoy().getName());
    }
}
