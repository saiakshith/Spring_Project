package com.nen.model;


import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "Students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="student_id")
    public int  id;

    @Size(min = 3, message = "username minimum length should be 3")
    @NotBlank(message = "username cannot be empty!")
    private String username;

    @Size(min = 10)
    @NotBlank
    @Email(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]+$", message = "email should be in this format ******@******.***")
    private String email;

    @NotBlank(message = "password cannot be empty!")
    @Size(min = 4, message = "Password minimum length should be 4!")
    private String password;

    @NotBlank(message = "country field cannot be empty!")
    private String country;

    @NotBlank(message = "Gender cannot be empty!")
    private String gender;

    @NotNull(message = "age can't be empty!")
    @Min(value = 18, message = "Minimum age should be above 18.")
    private Integer age;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
    System.out.println("I am get id method i am getting ur value ---------");
        return id;
    }

    public void setId(int id) {
    System.out.println("I Set id method setting ur id value -----------------------" + id);
        this.id = id;
    }

    public String getCountry() {
        System.out.println("I get country method getting ur country value -----------------------");

        return country;
    }

    public void setCountry(String country) {
        System.out.println("I get country method getting ur country value -----------------------" + country);

        this.country = country;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Student() {
    }

    public Student(int id, String username, String email, String password, String country, String gender, Integer age) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.country = country;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", country='" + country + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
}
