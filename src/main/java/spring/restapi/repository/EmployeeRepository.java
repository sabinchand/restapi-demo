package spring.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.restapi.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
