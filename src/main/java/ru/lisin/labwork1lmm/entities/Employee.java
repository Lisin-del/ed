package ru.lisin.labwork1lmm.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "address")
    private String address;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "position")
    private String position;
}
