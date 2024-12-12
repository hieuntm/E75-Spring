package ga.demo.spring.bean;

import ga.demo.spring.dto.Tire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Cấu hình
public class BeanTest2 {

    @Bean("YAMAHA")
    public Tire tire() { // tên là tire
        return new Tire();
    }
}
