package com.student;

public class Student {

    private int id;
    private String name;
    private int age;
    private String course;
    private String email;
    private String phone;

    // Default Constructor
    public Student() {
    }

    // Constructor without ID
    public Student(String name, int age, String course,
                   String email, String phone) {

        this.name = name;
        this.age = age;
        this.course = course;
        this.email = email;
        this.phone = phone;
    }

    // Constructor with ID
    public Student(int id, String name, int age, String course,
                   String email, String phone) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.email = email;
        this.phone = phone;
    }

    // Get ID
    public int getId() {
        return id;
    }

    // Set ID
    public void setId(int id) {
        this.id = id;
    }

    // Get Name
    public String getName() {
        return name;
    }

    // Set Name
    public void setName(String name) {
        this.name = name;
    }

    // Get Age
    public int getAge() {
        return age;
    }

    // Set Age
    public void setAge(int age) {
        this.age = age;
    }

    // Get Course
    public String getCourse() {
        return course;
    }

    // Set Course
    public void setCourse(String course) {
        this.course = course;
    }

    // Get Email
    public String getEmail() {
        return email;
    }

    // Set Email
    public void setEmail(String email) {
        this.email = email;
    }

    // Get Phone
    public String getPhone() {
        return phone;
    }

    // Set Phone
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {

        return "ID: " + id +
                ", Name: " + name +
                ", Age: " + age +
                ", Course: " + course +
                ", Email: " + email +
                ", Phone: " + phone;
    }
}