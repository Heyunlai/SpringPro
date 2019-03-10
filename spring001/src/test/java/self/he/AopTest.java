package self.he;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import self.he.service.HelloService;
import self.he.service.ProviderService;

/**
 * Unit test for simple App.
 */
public class AopTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void m1(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/applicationContext.xml");

        //不是spring管理的bean，织入无效。
        ProviderService providerService = new ProviderService();
        providerService.add();

        ProviderService providerService1 = ctx.getBean("providerService", ProviderService.class);
        providerService1.add();
    }
    @Test
    public void m2(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/applicationContext.xml");

        HelloService helloService = ctx.getBean("helloService", HelloService.class);
        helloService.hello();

    }
}


