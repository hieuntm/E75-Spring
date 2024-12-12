package ga.demo.spring.dto;

public class Car {
    // Lốp xe, không phải là số bánh xe
    // Vô lăng,
    // Cửa kính
    // Bình xăng
    // Hãng

    // Tất cả trong java đều là object
    // Tạo các object tương ứng, phụ tùng tương ứng
    // Rồi mình kết hợp code -> ra cái xe

    // private String tire -> Lưu cái lốp xe dưới dạng String
    private Tire tire; // 1 bánh
    // Lưu cái lốp xe dưới dạng object

    private Wheel wheel; // 1 vô lăng
    // Khác trước là thay vì là thuộc tính lẻ, thông tin đơn giản
    // String brand - hãng xe
    // String color - màu xe
    // Bây giờ nó đc thay thế bằng các object
    // Trong các object có thể chứa các object con khác, và các thuộc tính của nó


    public Car() {
    }

    public Car(Tire tire, Wheel wheel) {
        this.tire = tire;
        this.wheel = wheel;
    }

    public Tire getTire() {
        return tire;
    }

    public void setTire(Tire tire) {
        this.tire = tire;
    }

    public Wheel getWheel() {
        return wheel;
    }

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }

    public void test(){
        for(int i = 500_000_000, step = 1; i <= 1_500_000_000; i*=3){
            System.out.println(++step); // dòng này chạy mấy lần
        }
    }

}
