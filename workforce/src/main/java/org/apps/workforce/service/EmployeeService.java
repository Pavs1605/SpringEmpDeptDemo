package org.apps.workforce.service;

import org.apps.workforce.model.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee getEmployee(String empId);

    public List<Employee> getEmployeesList();


    public Employee updateEmployeeFields(String empId, Employee emp);

    public Employee updateEmployee(Employee emp);
    public Employee createEmployee(Employee emp);

    public String deleteEmployee(String empId);
    



}
