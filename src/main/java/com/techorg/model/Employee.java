package com.techorg.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Employee")
@Data // generates getters, setters, toString, equals, hashCode
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT in MySQL
    @Column(name = "EmployeeID")
    private Integer employeeId;

    @Column(name = "Name", length = 200, nullable = false)
    private String name;

    @Column(name = "Email", length = 100, unique = true, nullable = false)
    private String email;

    @Column(name = "Designation", length = 100)
    private String designation;

    @Column(name = "DepartmentID")
    private Integer departmentId;

}
