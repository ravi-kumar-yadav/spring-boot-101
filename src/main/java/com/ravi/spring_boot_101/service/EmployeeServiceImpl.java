package com.ravi.spring_boot_101.service;

import com.ravi.spring_boot_101.dao.EmployeeRepository;
import com.ravi.spring_boot_101.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(long id) {
        Optional<Employee> dbEmployee = employeeRepository.findById(id);
        // same as: return dbEmployee.isPresent() ? dbEmployee.get() : null;
        return dbEmployee.orElse(null);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(long id) {
        employeeRepository.deleteById(id);
        return;
    }
}
