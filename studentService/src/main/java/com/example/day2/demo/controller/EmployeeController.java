package com.example.day2.demo.controller;

import com.example.day2.demo.entity.Employee;
import com.example.day2.demo.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor // Tự sinh các constructor
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;


    @GetMapping// ko cần path
    public ResponseEntity<List<Employee>> getAllBook() { // tên method trong controller, ko quan trọng
        return ResponseEntity.ok(employeeRepository.findAll());
    }

}
