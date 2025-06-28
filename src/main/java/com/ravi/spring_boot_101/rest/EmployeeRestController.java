package com.ravi.spring_boot_101.rest;

import com.ravi.spring_boot_101.dao.EmployeeDAO;
import com.ravi.spring_boot_101.entity.Employee;
import com.ravi.spring_boot_101.service.EmployeeService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> fetchAllStudents(){
        return employeeService.findAll();
    }

}
