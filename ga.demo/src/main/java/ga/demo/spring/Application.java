package ga.demo.spring;

import ga.demo.spring.dto.Car;
import ga.demo.spring.dto.Tire;
import ga.demo.spring.dto.Wheel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);


		Tire tire = new Tire();
		Wheel wheel = new Wheel();

		Car car = new Car(tire, wheel); // Có constructor
		car.setTire(tire); // ko constructor
		car.setWheel(wheel);

		System.out.println(car);
		// dòng 15 -> dòng 20
		// Java core -> tạo được một object liên quan tới xe
		// Product p = new Product(// truyền thông tin vào đây)
		// thông tin là nhập vào
		// ProductService = new ProductService(myConnection)
		// Để tạo 1 object chứa nhiều object con bên trong,
		// Thì cần phải tạo các object(1) code bên trong, rồi truyền vào hoặc dùng
		// setter để set gía trị cho object(1)
	}

	// IoC -> Inversion of control
	// Đảo ngược điều khiển/kiểm soát
	// Pattern thiết kế code
	// Giảm sự phụ thuộc, từ component cha với component con

	// IoC Container -> Chỗ kiểm soát sự đảo chiều trên
	// đảo ngược sự phụ thuộc giữa các component với nhau
}
