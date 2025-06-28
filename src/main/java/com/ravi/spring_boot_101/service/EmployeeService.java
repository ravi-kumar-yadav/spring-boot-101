package com.ravi.spring_boot_101.service;

import java.util.List;
import com.ravi.spring_boot_101.entity.Employee;

public interface EmployeeService {

    List<Employee> findAll();
}
