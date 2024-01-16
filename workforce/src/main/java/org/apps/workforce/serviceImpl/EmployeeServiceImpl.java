package org.apps.workforce.serviceImpl;

import jakarta.transaction.Transactional;
import org.apps.workforce.model.Employee;
import org.apps.workforce.repository.EmployeeRepository;
import org.apps.workforce.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository empRepository;

    public EmployeeServiceImpl(EmployeeRepository empRepository) {
        this.empRepository = empRepository;
    }

    @Override
    public Employee getEmployee(String empId) {
        Optional<Employee> empOp = empRepository.findById(empId);
        return empOp.isPresent() ? empOp.get() : null;
    }

    @Override
    public List<Employee> getEmployeesList() {
       return empRepository.findAll();
    }

    @Override
    public Employee updateEmployeeFields(String empId, Employee emp) {
        Employee empExisting = empRepository.findById(empId).get();
        if(emp.getEmployeeName() != null)
            empExisting.setEmployeeName(emp.getEmployeeName());

        if(emp.getEmployeePosition() != null)
            empExisting.setEmployeePosition(emp.getEmployeePosition());


        if(emp.getEmployeeEmailAddress() != null)
            empExisting.setEmployeeEmailAddress(emp.getEmployeeEmailAddress());

        if(emp.getEmployeeSalary() > 0)
            empExisting.setEmployeeSalary(emp.getEmployeeSalary());

        empRepository.save(empExisting);

        return empExisting;
    }

    @Override
    public Employee updateEmployee(Employee emp) {
        empRepository.save(emp);
        return emp;
    }

    @Override
    public Employee createEmployee(Employee emp) {
        empRepository.save(emp);
        return emp;
    }

    @Override
    public String deleteEmployee(String empId) {
       empRepository.deleteById(empId);
       return "Employee deleted successfully";
    }
}
