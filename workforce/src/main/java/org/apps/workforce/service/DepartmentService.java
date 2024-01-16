package org.apps.workforce.service;

import org.apps.workforce.model.Department;
import org.apps.workforce.model.Employee;

import java.util.List;

public interface DepartmentService {

    public Department getDepartment(String deptId);

    public List<Department> getDepartmentsList();


    public Department updateDepartmentFields(String deptId, Department dept);

    public Department updateDepartment(Department dept);
    public Department createDepartment(Department dept);

    public String deleteDepartment(String deptId);

    public Department addEmployeeToDepartment(String deptId, String empId);

    public String deleteEmployeeFromDepartment(String deptId, String empId);

    public List<Employee> getEmployeesPerDepartment(String deptId);


}
