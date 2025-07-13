package com.ravi.spring_boot_101.dao;

import com.ravi.spring_boot_101.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
