package spring.restapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.restapi.entity.Employee;
import spring.restapi.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //SAVE AN EMPLOYEE
    @PostMapping("/employees")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    //GET A EMPLOYEE
    @GetMapping("/employee")
    public ResponseEntity<Employee> getEmployeeById(@RequestParam Long id){
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    //GET ALL EMPLOYEES
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    //UPDATE A EMPLOYEE
    @PutMapping("/employee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @RequestParam Long id){
        return new ResponseEntity<>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
    }

    //DELETE A EMPLOYEE
    @DeleteMapping("/employee")
    public void deleteEmployeeById(@RequestParam Long id){
        employeeService.deleteEmployee(id);
    }








}
