package self.he;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import self.he.pojo.Cat;

public class AutowireTest {
    @Test
    public void  m1(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"autowire.xml"});
        Cat cat = ctx.getBean("cat",Cat.class);
        System.out.println(cat.getGirl().getName());

    }
}
