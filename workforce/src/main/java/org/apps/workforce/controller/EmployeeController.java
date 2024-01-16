package org.apps.workforce.controller;

import org.apps.workforce.model.Employee;
import org.apps.workforce.model.Employee;
import org.apps.workforce.service.EmployeeService;
import org.apps.workforce.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:3000", methods={RequestMethod.DELETE,RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST, RequestMethod.PATCH})
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @RequestMapping(method = RequestMethod.OPTIONS)
    public ResponseEntity<?> handleOptions() {
        return ResponseEntity.ok().build();
    }
    @GetMapping()
    public List<Employee> getAllEmployees()
    {
        return employeeService.getEmployeesList();
    }

    @GetMapping("{empId}")
    public Employee getEmployee(@PathVariable("empId") String empId)
    {
        return employeeService.getEmployee(empId);
    }


    @DeleteMapping("{empId}")
    public String deleteEmployee(@PathVariable("empId") String empId)
    {
        employeeService.deleteEmployee(empId);
        return "Employee " + empId + " Successfully deleted";
    }

    @PatchMapping("{empId}")
    public Employee updateEmployeeByFields(@PathVariable("empId") String empId, @RequestBody Employee emp)
    {
        return employeeService.updateEmployeeFields(empId, emp);
    }

    @PutMapping
    public Employee updateEmployee(@RequestBody Employee emp)
    {
        return employeeService.updateEmployee(emp);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee emp)
    {
        return employeeService.createEmployee(emp);
    }

   
}
