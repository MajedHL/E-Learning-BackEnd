package com.mh.api.MhAPI.models;

import jakarta.persistence.*;


import java.time.LocalDate;


@Entity
@Table(name = "students")
public class Student {


    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private  Long id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Version
    @Column(nullable = false)
    private int version;

   @Transient
    private Integer age;

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getAge() {
        return birthDate.until(LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
