package spring.restapi.service;

import org.springframework.stereotype.Service;
import spring.restapi.entity.Employee;
import spring.restapi.exception.ResourceNotFoundException;
import spring.restapi.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", id));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee updatedEmployee, Long id) {
        Optional<Employee> oldEmployee = employeeRepository.findById(id);
        if (oldEmployee.isPresent()){
            oldEmployee.get().setFirstName(updatedEmployee.getFirstName());
            oldEmployee.get().setLastName(updatedEmployee.getLastName());
            oldEmployee.get().setEmail(updatedEmployee.getEmail());
            return employeeRepository.save(oldEmployee.get());
        }else{
            throw new ResourceNotFoundException("Employee", "Id", id);
        }
    }

    @Override
    public void deleteEmployee(Long id) {
        Optional<Employee> employeeToDelete = employeeRepository.findById(id);
        if(employeeToDelete.isPresent()){
            employeeRepository.deleteById(id);
        }else{
            throw new ResourceNotFoundException("Employee", "Id", id);
        }
    }

}
