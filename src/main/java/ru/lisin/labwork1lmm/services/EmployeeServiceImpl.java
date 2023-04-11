package ru.lisin.labwork1lmm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.lisin.labwork1lmm.entities.Department;
import ru.lisin.labwork1lmm.entities.Employee;
import ru.lisin.labwork1lmm.repositories.EmployeeRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a full name: ");
        String empName = scanner.nextLine();

        System.out.print("Enter an address: ");
        String empAddress = scanner.nextLine();

        System.out.print("Enter a department name: ");
        String depName = scanner.nextLine();
        Department department = departmentService.findByDepartmentName(depName);

        if (department == null) {
            System.out.println("Department with " + depName + " doesn't exist");
            return null;
        }

        System.out.print("Enter birthday (format 2000-01-01): ");
        LocalDate parsedBirthday = LocalDate.parse(scanner.nextLine());

        System.out.print("Enter a position: ");
        String empPosition = scanner.nextLine();

        Employee newEmployeeEntity = Employee.builder()
                .fullName(empName)
                .address(empAddress)
                .department(department)
                .birthday(parsedBirthday)
                .position(empPosition)
                .build();
        employeeRepository.save(newEmployeeEntity);
        return newEmployeeEntity;
    }

    @Override
    public void deleteEmployee(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public Employee findByEmployeeName(String name) {
        return employeeRepository.findByEmployeeName(name);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
