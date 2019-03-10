package self.she.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import self.she.Boy;
import self.she.Girl;

@Configuration
@ComponentScan(value = "self.she")
public class SpringConfig {

    @Bean("girl")
    public Girl creatGirl(){
        Girl girl = new Girl();
        girl.setName("Li");
        return girl;
    }

    @Bean("boy")
    public Boy creatBoy(){
        Boy boy = new Boy();
        boy.setName("He");
        return boy;
    }

}
