package org.gruzdov.spring.springboot.spring_data_jpa.controller;

import org.gruzdov.spring.springboot.spring_data_jpa.entity.Employee;
import org.gruzdov.spring.springboot.spring_data_jpa.exception_handling.NoSuchEmployeeException;
import org.gruzdov.spring.springboot.spring_data_jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {
    private EmployeeService employeeService;

    @Autowired
    public MyRESTController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        List<Employee> allEmployee = employeeService.getAllEmployees();

        return allEmployee;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        Employee employee = employeeService.getEmployee(id);

        if (employee == null)
            throw new NoSuchEmployeeException("There is no employee with ID = " +
                    id + " int Database");

        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);

        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);

        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null)
            throw new NoSuchEmployeeException("There is no employee with ID = " +
                    id + " in Database");

        employeeService.deleteEmployee(id);

        return "Employee with ID = " + id + " was deleted";
    }

    @GetMapping("/employees/name/{name}")
    public List<Employee> showAllEmployeesByName(@PathVariable String name) {
        List<Employee> employees = employeeService.findAllByName(name);

        return employees;
    }

}
