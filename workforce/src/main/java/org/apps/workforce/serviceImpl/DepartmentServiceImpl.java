package org.apps.workforce.serviceImpl;

import jakarta.transaction.Transactional;
import org.apps.workforce.model.Department;
import org.apps.workforce.model.Employee;
import org.apps.workforce.repository.DepartmentRepository;
import org.apps.workforce.repository.EmployeeRepository;
import org.apps.workforce.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository deptRepository;
    @Autowired
    EmployeeRepository empRepository;

    public DepartmentServiceImpl(DepartmentRepository deptRepository, EmployeeRepository empRepository) {
        this.deptRepository = deptRepository;
        this.empRepository = empRepository;
    }

    @Override
    public Department getDepartment(String deptId) {
       return deptRepository.findById(deptId).get();
    }

    @Override
    public List<Department> getDepartmentsList() {
        return deptRepository.findAll();
    }

    @Override
    public Department updateDepartmentFields(String deptId, Department dept) {
        Department deptExisting = deptRepository.findById(deptId).get();
        if(dept.getDepartmentName() != null)
            deptExisting.setDepartmentName(dept.getDepartmentName());

        if(dept.getDepartmentLocation() != null)
            deptExisting.setDepartmentLocation(dept.getDepartmentLocation());

        deptRepository.save(deptExisting);

        return deptExisting;
    }

    @Override
    public Department updateDepartment(Department dept) {
       deptRepository.save(dept);
       return dept;
    }

    @Override
    public Department createDepartment(Department dept) {
        deptRepository.save(dept);
        return dept;
    }

    @Override
    public String deleteDepartment(String deptId) {
        deptRepository.deleteById(deptId);
        return "Deleted department successfully";
    }

    @Override
    public Department addEmployeeToDepartment(String deptId, String empId) {
        Department dept = deptRepository.findById(deptId).get();

        Employee employee = empRepository.findById(empId).get();

        dept.getEmployees().add(employee);
        employee.setDepartment(dept);
        empRepository.save(employee);
       deptRepository.save(dept);
        return dept;
    }

    @Override
    public String deleteEmployeeFromDepartment(String deptId, String empId) {
        Department dept = deptRepository.findById(deptId).get();
        Employee employee = empRepository.findById(empId).get();

        dept.getEmployees().remove(employee);
        employee.setDepartment(null);
        empRepository.save(employee);
        deptRepository.save(dept);
        return "Employee deleted successfully";
    }

    @Override
    public List<Employee> getEmployeesPerDepartment(String deptId) {
        Department dept = deptRepository.findById(deptId).get();
        List<Employee> empList = new ArrayList<>(dept.getEmployees());
        return empList;
    }
}
