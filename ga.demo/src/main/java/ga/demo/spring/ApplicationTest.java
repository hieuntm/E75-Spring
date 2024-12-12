//package ga.demo.spring;
//
//import ga.demo.spring.bean.CarBean;
//import ga.demo.spring.dto.Car;
//import ga.demo.spring.dto.Tire;
//import ga.demo.spring.dto.Wheel;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.context.TypeExcludeFilter;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.FilterType;
//
//@SpringBootApplication
////@ComponentScan( // scan trong toàn bộ project
////		// tìm xem thằng nào bean, thằng nào dùng bean
////		// nhét container
////		excludeFilters = {@ComponentScan.Filter(
////				type = FilterType.CUSTOM,
////				classes = {TypeExcludeFilter.class}
////		), @ComponentScan.Filter(
////				type = FilterType.CUSTOM,
////				classes = {AutoConfigurationExcludeFilter.class}
////		)}
////)
//public class ApplicationTest {
//
//	public static void main(String[] args) {
//		ApplicationContext ctx = // container
//				SpringApplication.run(ApplicationTest.class, args);
//
//		Tire tire3 = (Tire) ctx.getBean("HONDA");
//
//		CarBean carBean2 = (CarBean) ctx.getBean("carBean");
//
//		System.out.println(tire3);
//		System.out.println(carBean2);
//	}
//
//}
