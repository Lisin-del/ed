package ru.lisin.labwork1lmm.services;

import ru.lisin.labwork1lmm.entities.Department;

import java.util.List;

public interface DepartmentService {
    Department addDepartment();

    void deleteDepartment(int depId);

    Department findByDepartmentName(String name);

    List<Department> getAllDepartments();
}
