package ga.demo.spring.restful.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller // dùng cho MVC
//@ResponseBody

@RestController // dùng cho Restful
// RestController = Controller + ResponseBody
@RequestMapping("/api/v1/car")
public class CarController {
    // Trong 1 file controller, không được phép
    // có 2 api trùng tên trùng method (POST, PUT)
    // Get
    // /api/v1/car/honda
    @GetMapping("/honda")// nối với cả RequestMapping ở trên
    // function trả về dữ liệu mà mình muốn
    // Khi mà có getMapping, hoặc các method khác
    // tên function ko quan trọng
    public String helloWolrd(){
        return "Hello Honda";
    }

    // /api/v1/car -> /api/v1/car/ -> sai
    @GetMapping// nếu mà ko có path như ở trên nó sẽ lấy cái
    // ở RequestMapping
    public String helloWolrd2(){
        return "Hello Yamaha";
    }

    // /api/v1/car
    @GetMapping("/path/{nameRef}")// nếu mà ko có path như ở trên nó sẽ lấy cái
    // ở RequestMapping

    // Ở dấu ngoặc tròn sau tên function
    // các bạn phải thêm @PathVairable kèm theo tên biến, và kiểu dữ liệu
    // truyền tên tham chiếu trên path vào PathVairable
    public String helloWolrdWithPathVariable(@PathVariable("nameRef") String name){
        return "Hello " + name;
    }
    
    // /api/v1/car
    // /api/v1/car/honda
    // -> path
    // có host có port và path
    // host: localhost - 127.0.0.1
    // port: 8080
    // để sửa port thêm thuộc tính server.port vào file application.properties
    // trong folder resources

}
