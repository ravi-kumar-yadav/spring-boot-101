package com.ravi.spring_boot_101.rest;

import com.ravi.spring_boot_101.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void init(){
        students = new ArrayList<>();

        students.add(new Student("Krishna", "Yadav"));
        students.add(new Student("Subhadra", "Yadav"));
        students.add(new Student("Balram", "Yadav"));
    }

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        System.out.println("Returning all students for endpoint: /api/students");
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId){
        if (studentId < 0 || studentId >= students.size()){
            throw new StudentNotFoundException("Student not found for studentId: " + studentId);
        }
        return students.get(studentId);
    }
}
