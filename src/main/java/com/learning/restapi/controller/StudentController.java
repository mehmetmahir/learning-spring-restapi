package com.learning.restapi.controller;

import com.learning.restapi.entity.Student;
import com.learning.restapi.repository.IStudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
     final IStudentRepository studentRepository;

    public StudentController(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public List<Student> getAllStudents(){
        List<Student> students = studentRepository.findAll();
        return students;
    }
    
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id){
        Student student= studentRepository.findById(id).get();
        return student;
    }

    @PostMapping("/add")
    @ResponseStatus( code = HttpStatus.CREATED)
    public void addStudent(@RequestBody Student student){
        studentRepository.save(student);
    }

    @PutMapping("/update/{id}")
    public void updateStudent(@PathVariable int id, @RequestBody Student student){
        Student updatedStudent = studentRepository.findById(id).get();
        updatedStudent.setName(student.getName());
        updatedStudent.setSurname(student.getSurname());
        updatedStudent.setStudentDepartment(student.getStudentDepartment());
        studentRepository.save(updatedStudent);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id){
        Student removedStudent = studentRepository.findById(id).get();
        studentRepository.delete(removedStudent);
    }


}
