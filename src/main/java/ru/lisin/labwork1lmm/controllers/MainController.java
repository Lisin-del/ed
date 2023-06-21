package ru.lisin.labwork1lmm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.lisin.labwork1lmm.entities.Department;
import ru.lisin.labwork1lmm.entities.Employee;
import ru.lisin.labwork1lmm.services.DepartmentService;
import ru.lisin.labwork1lmm.services.EmployeeService;

import java.util.List;

@RestController
public class MainController {
    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String addDepsAndEmployees() {
        departmentService.addDepartment();
        employeeService.addEmployee();
        return "Done";
    }

    @RequestMapping(path = "/all-emp", method = RequestMethod.GET)
    @Secured(value = "USER")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @RequestMapping(path = "/all-dep", method = RequestMethod.GET)
    @Secured(value = "ADMIN")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }
}
