package org.gruzdov.spring.springboot.spring_data_jpa.service;


import org.gruzdov.spring.springboot.spring_data_jpa.dao.EmployeeRepository;
import org.gruzdov.spring.springboot.spring_data_jpa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(Long id) {
        Employee employee = null;
        Optional<Employee> optional = employeeRepository.findById(id);
        if (optional.isPresent())
            employee = optional.get();

        return employee;
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAllByName(String name) {
        List<Employee> employees = employeeRepository.findAllByName(name);

        return employees;
    }

}
