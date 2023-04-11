package ru.lisin.labwork1lmm.services;

import ru.lisin.labwork1lmm.entities.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee();

    void deleteEmployee(int empoyeeId);

    Employee findByEmployeeName(String name);

    List<Employee> getAllEmployees();

}
