package com.example.day2.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_student")
public class Student {

    // JDBC -> Hibernate/JPA -> Spring Data JPA
    // JDBC:  dùng Connection, PreparedStatement, ResultSet

    // Hibernate/JPA là ORM -> Mapping object trong java với table trong db
    //

    // Spring data JPA -> Dựa vào 2 thằng trên

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    public Student() {
    }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
