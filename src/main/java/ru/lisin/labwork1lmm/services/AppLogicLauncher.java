package ru.lisin.labwork1lmm.services;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lisin.labwork1lmm.entities.Department;
import ru.lisin.labwork1lmm.entities.Employee;

import java.util.Scanner;

@Service
public class AppLogicLauncher {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @PostConstruct
    private void launchAppLogic() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            System.out.println("What command do you want to execute? (addE, delE, findE, findAllE, addD, delD, findD, findAllD, exit)");
            String commandToExecute = scanner.nextLine();

            switch (commandToExecute) {
                case "addE" -> employeeService.addEmployee();
                case "delE" -> {
                    System.out.print("Enter an employee id: ");
                    int employeeId = scanner.nextInt();
                    employeeService.deleteEmployee(employeeId);
                    scanner.nextLine();
                }
                case "findE" -> {
                    System.out.print("Enter an employee name: ");
                    Employee employee = employeeService.findByEmployeeName(scanner.nextLine());
                    System.out.println(employee);
                }
                case "findAllE" -> {
                    employeeService.getAllEmployees().forEach(System.out::println);
                }
                case "addD" -> departmentService.addDepartment();
                case "delD" -> {
                    System.out.print("Enter a department id: ");
                    departmentService.deleteDepartment(scanner.nextInt());
                    scanner.nextLine();
                }
                case "findD" -> {
                    System.out.print("Enter a department name: ");
                    Department byDepartmentName = departmentService.findByDepartmentName(scanner.nextLine());
                    System.out.println(byDepartmentName.toString());
                }
                case "findAllD" -> {
                    departmentService.getAllDepartments().forEach(System.out::println);
                }
                case "exit" -> flag = false;
                default -> System.out.println("Your command [" + commandToExecute + "] has not been found!");
            }
        }
    }
}
