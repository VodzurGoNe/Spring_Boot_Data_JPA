package org.gruzdov.spring.springboot.spring_data_jpa.service;


import org.gruzdov.spring.springboot.spring_data_jpa.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployee(Long id);

    void deleteEmployee(Long id);

    List<Employee> findAllByName(String name);

}
