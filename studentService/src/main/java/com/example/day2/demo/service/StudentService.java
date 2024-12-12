package com.example.day2.demo.service;

import com.example.day2.demo.entity.Student;
import com.example.day2.demo.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    // liên quan đến data -> gọi repository
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

//    List<Student> students = new ArrayList<>();
    // List hay là Map -> bản chất là lưu ở ram
    // Repository tương tác trực tiếp với database

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public Student getStudentById(int id) {
        Optional<Student> studentOptional = studentRepository.findById(id);

        // Optional -> Hộp chứa dữ liệu -> Nếu có trả ra, nếu ko thì trả về null
        // Optional.get trả về dữ liệu nằm trong hộp
        // Optional.orElse trả về dữ liệu nằm trong hộp, nếu không có trả về null
        return studentOptional.orElse(null);
    }

    public Student createStudent(Student student) {
        // hàm save trong repository, dựa vào id mà quyết định action
        // nếu id > 0 và tồn tại rồi thì là update
        // nếu id = 0 và -1 là tao mới
        student.setId(0);
        return studentRepository.save(student);
    }

    public Student updateStudent(int id, Student student) {
        Student foundStudent = getStudentById(id);

        // id từ path
        // student từ body -> Thông tin tôi muốn update
        // foundStudent là object nằm trong database
        student.setId(id);
        if (foundStudent != null) {
            BeanUtils.copyProperties(student, foundStudent);
            // Copy tất cả thuộc tính từ thằng student sang foundStudent(student nằm trong database)
            studentRepository.save(foundStudent);
        }
        return null;
    }

    public boolean deleteStudentById(int id) {
        studentRepository.deleteById(id);
        return true;
    }
}
