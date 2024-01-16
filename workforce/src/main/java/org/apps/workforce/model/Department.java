package org.apps.workforce.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="departments")

public class Department {
    @Id
    String departmentId;
    String departmentName;
    String departmentLocation;
    @JsonManagedReference
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    Set<Employee> employees;

    public Department()
    {
        this.employees = new HashSet<>();
    }
    public Department(String departmentId, String departmentName, String departmentLocation, Set<Employee> employees) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentLocation = departmentLocation;
        this.employees = new HashSet<>();
    }

    public String getDepartmentLocation() {
        return departmentLocation;
    }

    public void setDepartmentLocation(String departmentLocation) {
        this.departmentLocation = departmentLocation;
    }


    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
