package org.apps.workforce.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name="employees")
public class Employee {

    @Id
    String employeeId;
    String employeeName;

    String employeePosition;
    double employeeSalary;

    String employeeEmailAddress;

    String departmentName;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "deptId", nullable = true)
    private Department department;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(String employeePosition) {
        this.employeePosition = employeePosition;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeeEmailAddress() {
        return employeeEmailAddress;
    }

    public void setEmployeeEmailAddress(String employeeEmailAddress) {
        this.employeeEmailAddress = employeeEmailAddress;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getDepartmentName() {
        return department != null ? department.departmentName : null;
    }

}
