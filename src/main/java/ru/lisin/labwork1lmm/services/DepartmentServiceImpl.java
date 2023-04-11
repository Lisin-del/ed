package ru.lisin.labwork1lmm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.lisin.labwork1lmm.entities.Department;
import ru.lisin.labwork1lmm.repositories.DepartmentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department addDepartment() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a department name: ");
        String depName = scanner.nextLine();

        System.out.print("Enter the employee count: ");
        int employeeCount = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the room names (example: room1,room2,room3...): ");
        String roomNames = scanner.nextLine();

        Department department = Department.builder()
                .name(depName)
                .employeeCount(employeeCount)
                .roomNames(List.of(roomNames.split(",")))
                .build();
        departmentRepository.save(department);
        return department;
    }

    @Override
    public void deleteDepartment(int depId) {
        departmentRepository.deleteById(depId);
    }

    @Override
    public Department findByDepartmentName(String name) {
        return departmentRepository.findByDepartmentName(name);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
}
