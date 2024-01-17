package org.apps.workforce.controller;

import org.apps.workforce.model.Department;
import org.apps.workforce.model.Employee;
import org.apps.workforce.service.*;
import org.apps.workforce.serviceImpl.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/departments")
@CrossOrigin(origins = "*", methods={RequestMethod.DELETE,RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST, RequestMethod.PATCH})
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;
    public DepartmentController() {
    }

    public DepartmentController(DepartmentService departmentService)
    {
        this.departmentService = departmentService;
    }

    @RequestMapping(method = RequestMethod.OPTIONS)
    public ResponseEntity<?> handleOptions() {
        return ResponseEntity.ok().build();
    }


   @GetMapping("{deptId}")
    public Department getDepartment(@PathVariable("deptId") String deptId)
    {
        return departmentService.getDepartment(deptId);
    }

    @GetMapping()
    public List<Department> getAllDepartments()
    {
        return departmentService.getDepartmentsList();
    }

    @DeleteMapping("{deptId}")
    public String deleteDepartment(@PathVariable("deptId") String deptId)
    {
         departmentService.deleteDepartment(deptId);
         return "Department " + deptId + " Successfully deleted";
    }

    @PatchMapping("{deptId}")
    public Department updateDepartmentByFields(@PathVariable("deptId") String deptId, @RequestBody Department dept)
    {
        return departmentService.updateDepartmentFields(deptId, dept);

    }

    @PutMapping
    public Department updateDepartment(@RequestBody Department dept)
    {
        return departmentService.updateDepartment(dept);
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department dept)
    {
        return departmentService.createDepartment(dept);
    }

    @PostMapping("/addEmployeeToDepartment/{deptId}/{empId}")
    public Department addEmployeeToDepartment( @PathVariable("deptId") String deptId, @PathVariable("empId") String empId )
    {
        return departmentService.addEmployeeToDepartment(deptId, empId);

    }

    @GetMapping("/{deptId}/employees")
    public List<Employee> getEmployeesPerDepartment( @PathVariable("deptId") String deptId )
    {
       return departmentService.getEmployeesPerDepartment(deptId);

    }


    @DeleteMapping("/deleteEmployeeFromDepartment/{deptId}/{empId}")
    public String deleteEmployeeFromDepartment( @PathVariable("deptId") String deptId, @PathVariable("empId") String empId )
    {
        departmentService.deleteEmployeeFromDepartment(deptId, empId);
        return "Employee deleted from department successfully";
    }


}
