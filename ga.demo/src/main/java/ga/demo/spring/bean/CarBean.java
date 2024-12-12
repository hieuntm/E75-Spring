package ga.demo.spring.bean;


import ga.demo.spring.dto.Tire;
import ga.demo.spring.dto.Wheel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// Sử dụng
@Component // Class là bean
public class CarBean {

    // Để nhúng vào object cha
    // -> Dependency injection
    // Nhúng sự phụ thuộc
    // Tiêm sự phụ thuộc

    // Cách injection bean
    // Cách 1: Autowired -> Tự tìm cái bean có tên trùng với tên biến
    // để nhúng vào
    private Tire tire;
    private Wheel wheel;

    // Cách 2: Dùng constructor // Khởi tạo giá trị
    // M đang có 2 bean, giống hệt nhau, ko biết nhúng cái nào
    public CarBean(@Qualifier("HONDA") Tire tire, Wheel wheel) {
        this.tire = tire;
        this.wheel = wheel;
    }

    // Cách 3: Dùng setter // đặt lại giá trị -> Phục vụ cho testing
    public void setTire(Tire tire) {
        this.tire = tire;
    }

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }


    @Override
    public String toString() {
        return "CarBean{" +
                "tire=" + tire +
                ", wheel=" + wheel +
                '}';
    }
}
