package org.gruzdov.spring.springboot.spring_data_jpa.dao;


import org.gruzdov.spring.springboot.spring_data_jpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAllByName(String name);
}
