package com.example.day2.demo.repository;

import com.example.day2.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // Tôi đang ko biết, dùng bảng database nào, cái nào là primary key

    // query
    // viết query
    // xử lý query
    // Thằng repository nếu mà ko tự viết code bằng jdbc, hibernate hay là jpa
    // Thì chúng ta sẽ dùng inteface và kế thừa CRUDRepository hoặc JpaRepository
    // Và 2 CRUD và JPA, cung cấp sẵn function liên quan đến query cho mình


    // Liên quan đến data
    // JDBC -> myconnection
    // hoàn toàn dùng JDBC được

    // Sang phần này, dùng spring data jpa để thiết kế
    // JPA -> ORM -> Object relational mapping
    // Cho phép chúng ta kết nối java class với table trong database dạng 1-1
    // Để thiết kế đoạn mapping, mapping ở trong Entity/Modal

    @Query(value = "select * from tbl_student where age between ? and ?", nativeQuery = true)

//    @Query("FROM Student s where s.age between ? and ?")  -> HQL
        // 2 cách viết, 1 là native, 2 là ko native
        // Native: SQL thuần: Select * from tbl_student where age > min and age < max
        // Native: SQL thuần: Select * from tbl_student where age between min and max

        // Ko Native HQL:
    List<Student> findByAgeRange(int min, int max);
    // Custom query
}
