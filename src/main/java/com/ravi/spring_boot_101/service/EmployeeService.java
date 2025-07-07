package com.ravi.spring_boot_101.service;

import java.util.List;
import com.ravi.spring_boot_101.entity.Employee;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(long id);

    Employee save(Employee employee);

    void deleteById(long id);
}
