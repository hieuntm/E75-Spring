package ga.demo.spring.bean;

import ga.demo.spring.dto.Tire;
import ga.demo.spring.dto.Wheel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Khi trong 1 file có @Bean
// @Bean nó đứng trước function
// cần thêm 1 annotation để quyết định class này, chứa các bean
@Configuration // Cấu hình
public class BeanTest {

    // Container -> Box, hộp
    // Configuration -> Nói với cái hộp là trong class này
    //  thằng nào có @Bean, thì m nhét vào cái hộp
    // Mỗi 1 function là 1 bean
    // tên method chính là tên bean


    @Bean("HONDA")
    public Tire tire(){ // tên là tire
        return new Tire();
    }
    // tất cả các bean, chỉ được khởi tạo 1 lần
    // cho tới khi project tắt
    // BeanScope -> singleton - chỉ 1 , session - web , prototype(nhiều)
    @Bean
    public Wheel wheel(){ // tên là wheel
        return new Wheel();
    }
}
