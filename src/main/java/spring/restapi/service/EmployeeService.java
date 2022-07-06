package spring.restapi.service;

import spring.restapi.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    Employee getEmployeeById(Long id);

    List<Employee> getAllEmployees();

    Employee updateEmployee(Employee updatedEmployee, Long id);

    void deleteEmployee(Long id);
}
