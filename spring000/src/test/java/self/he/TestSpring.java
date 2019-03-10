package self.he;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import self.he.pojo.Girl;
import self.he.pojo.People;
import self.he.pojo.PrettyGirl;

import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class TestSpring
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void  m1(){
        //获取上下文对象，spring里面声明对象都需要通过上下文获取
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//  扫描多个配置文件
//  ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml","beans.xml"});
        //通过此对象获取girl
        Girl g = (Girl) ctx.getBean("girl");
        //Girl g = ctx.getBean("girl",Girl.class);
        System.out.println(g.getName());
        ((PrettyGirl)g).show();
    }

    @Test
    public void  m2People(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"peopleBeans.xml"});
        People people = ctx.getBean("people", People.class);

        System.out.println(Arrays.toString(people.getFriends()));
//
//        System.out.println(people.getFriends().length);

        System.out.println(people.getNums());

        System.out.println(people.getGrils());

        System.out.println(people.getGoddessMap().get("Li"));
    }
}
