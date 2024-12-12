package com.example.day2.demo.controller;

import com.example.day2.demo.entity.Student;
import com.example.day2.demo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    // Đoạn này
    // Trong spring mọi thứ là bean
    // Để sử dụng 1 bean trong 1 bean khác, thì dùng kĩ thuật tiêm nhiễm sự phụ thuộc
    private final StudentService studentService;

    // Tiêm vào constructor
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent() { // tên method trong controller, ko quan trọng
        return ResponseEntity.ok(studentService.getAllStudent());
        // trả về 1 list student
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") int id) { // tên method trong controller, ko quan trọng
        Student student = studentService.getStudentById(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
        // trả về 1 student theo id
    }

    // Tạo resource thông qua api post
    // ClassObject ở request body có tham số gì, thì nhét hết vào request body dưới dạng json
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) { // tên method trong controller, ko quan trọng
        Student createStudent = studentService.createStudent(student);
        return ResponseEntity.ok(createStudent);
        // tạo mới student
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable("id") int id, @RequestBody Student student) { // tên method trong controller, ko quan trọng
        studentService.updateStudent(id, student);
        return ResponseEntity.ok("Student a");
        // update student
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int id) { // tên method trong controller, ko quan trọng
        // Xoá 1 item trong list
        // -> 1 là truyền số vào, xoá theo index
        // -> 2 là truyền object vào, xoá theo object
        studentService.deleteStudentById(id);
        return ResponseEntity.ok("Delete book id: " + id);
    }


    // Request và response là 2 thông số, chúng ta có thể linh hoạt
    // Thường thì không theo 1 cái chuẩn
    // request: api (requestMapping) + id
    // response: trả về statusCode, message gì đấy, và thông tin cần trả (do mình tự định nghĩa)
}

