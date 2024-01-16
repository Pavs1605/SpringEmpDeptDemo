package org.apps.workforce.repository;

import org.apps.workforce.model.Department;
import org.apps.workforce.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
