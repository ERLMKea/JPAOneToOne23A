package org.example.jpaonetoone23a.repositories;

import org.example.jpaonetoone23a.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findEmployeeByName(String name);

}
