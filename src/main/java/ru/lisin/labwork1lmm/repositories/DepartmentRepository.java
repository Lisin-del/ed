package ru.lisin.labwork1lmm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.lisin.labwork1lmm.entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    @Query(value = "select d FROM Department d WHERE d.name = :name")
    Department findByDepartmentName(@Param("name") String name);
}
