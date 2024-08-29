package org.example.jpaonetoone23a.repositories;

import org.example.jpaonetoone23a.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


}
