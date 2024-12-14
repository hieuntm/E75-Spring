package com.example.day2.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
// Constructor có tham số
// Constructor không có tham số
@Getter
@Setter
@Entity
@Table(name = "accounts")
// Account công ty
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // Nếu mà không có column thì nó mặc định chuyển sang snake
    private Integer id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    @OneToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name="employee_number")
    private Employee employee;
}
