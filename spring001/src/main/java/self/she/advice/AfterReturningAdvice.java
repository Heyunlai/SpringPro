package self.she.advice;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterReturningAdvice {
    @AfterReturning(value = "execution(* self.she.service.HelloService.eat())",returning = "returning")
    public void afterReturn(String returning){
        System.out.println("after returning!!! She is :"+returning);
    }
}
