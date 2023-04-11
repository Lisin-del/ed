package ru.lisin.labwork1lmm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.lisin.labwork1lmm.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "select e from Employee e where e.fullName = :fullName")
    Employee findByEmployeeName(@Param("fullName") String fullName);
}
