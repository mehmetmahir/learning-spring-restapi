package com.learning.restapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    @Column(name = "student_name", nullable = false)
    private String name;

    @Column(name = "student_surname", nullable = false)
    private String surname;

    @Column(name = "student_department", nullable = false)
    private String studentDepartment;

    @Column(name = "student_email", nullable = false, unique = true)
    private String studentEmail;

    public Student() {

    }
    public Student(String name, String surname, String studentDepartment, String studentEmail) {
        this.name = name;
        this.surname = surname;
        this.studentDepartment = studentDepartment;
        this.studentEmail = studentEmail;
    }


    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getStudentDepartment() {
        return studentDepartment;
    }

    public void setStudentDepartment(String studentDepartment) {
        this.studentDepartment = studentDepartment;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", studentDepartment='" + studentDepartment + '\'' +
                ", studentEmail='" + studentEmail + '\'' +
                '}';
    }
}
