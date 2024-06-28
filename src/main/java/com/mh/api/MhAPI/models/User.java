package com.mh.api.MhAPI.models;

import jakarta.persistence.*;


import java.time.LocalDate;


@Entity
@Table(name = "student")
public class User {


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
    private Long id;

    private String firstName;

    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    private String password;

    @Enumerated(EnumType.ORDINAL)
    private UserStatus statusSelect;

    @Version
    @Column(nullable = false)
    private int version;


   @Transient
    private Integer age;


    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public UserStatus getStatusSelect() {
        return statusSelect;
    }

    public void setStatusSelect(UserStatus statusSelect) {
        this.statusSelect = statusSelect;
    }

    public Integer getAge() {
        return birthDate.until(LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
