package com.example.day2.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // Nếu mà không có column thì nó mặc định chuyển sang snake
    private Integer id;
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "tasks")
    private List<Employee> employees = new ArrayList<>();

}
