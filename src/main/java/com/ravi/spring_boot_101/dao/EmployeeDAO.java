package com.ravi.spring_boot_101.dao;

import com.ravi.spring_boot_101.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
