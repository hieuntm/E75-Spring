package com.example.day2.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

//@AllArgsConstructor // = RequiredArgsConstructor + NoArgsConstructor
// Tự sinh các constructor
@RequiredArgsConstructor
// Constructor có tham số
// Constructor không có tham số
@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee {
    //    `employeeNumber` int(11) NOT NULL,
//  `lastName` varchar(50) DEFAULT NULL,
//  `firstName` varchar(50) DEFAULT NULL,
//  `extension` varchar(10) DEFAULT NULL,
//  `email` varchar(100) DEFAULT NULL,
//  `officeCode` varchar(10) DEFAULT NULL,
//  `reportsTo` int(11) DEFAULT NULL,
//  `jobTitle` varchar(50) DEFAULT NULL,
    // Khi mà biến: đặt dạng camel case -> sang db nó tự convert sang dạng snake
    // VD: employeeNumber -> employee_number

    // Có id và GeneratedValue -> khi insert bằng query, thì skip cái id nó ra
    // id ~ primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_number") // Nếu mà không có column thì nó mặc định chuyển sang snake
    private Integer employeeNumber;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "extension")
    private String extension;
    @Column(name = "email") // CHỉnh tên column
    private String email;
    @Column(name = "office_code")
    private String officeCode;
    @Column(name = "reports_to")
    private Integer reportsTo; // quan he voi chinh no
    @Column(name = "job_title")
    private String jobTitle;

    // 1-1
    // cascade -> INSERT, UPDATE, DELETE
    // ALL -> Khi insert 1 thằng Employee,
    // thì cũng insert 1 thằng account

    // fetch -> Tìm, liên quan select
    // 2 kiểu là Lazy và EAGER
    // Lazy -> Khi nào object được gọi tới hàm
    // account thì mới lôi ra -> Tối ưu query, xử lý

    // EAGER -> Khi mà query Employee, đồng
    // thời query ra các account tương ứng

    @OneToOne(mappedBy = "employee") // Lấy theo tên biến
    private Account account;
    // 1-n

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name="department_id"
    )
    private Department department;

    // n-n

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinTable(name="task_employee",
            joinColumns= @JoinColumn(
                    name="employee_id",
                    referencedColumnName="employee_number"
            ),
            inverseJoinColumns = @JoinColumn(
                    name="task_id",
                    referencedColumnName="id"
            )
    ) // Join bảng -> bảng thứ 3
    private List<Task> tasks = new ArrayList<>();
}
