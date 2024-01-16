package org.apps.workforce.repository;

import org.apps.workforce.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface DepartmentRepository extends JpaRepository<Department, String> {
}
