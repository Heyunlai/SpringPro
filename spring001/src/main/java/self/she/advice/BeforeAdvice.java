package self.she.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect//标记为一个切面
@Component//标记为一个组件，相当于在xml中注册一个bean
public class BeforeAdvice {
    @Before("execution(* self.she.service.HelloService.hello(String,String))")
    //获取方法名，参数
    public void before(JoinPoint joinPoint){
        System.out.println("before!!!!!"+joinPoint.getSignature().getName()+ Arrays.toString(joinPoint.getArgs()));
    }
    @Before("execution(* self..*.*(..))")
    public void before2(){
        System.out.println("before2!!!");
    }
}
