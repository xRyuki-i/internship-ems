package com.internship.ems.model;

import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Entity
@Table(name = "employee", schema = "ems", uniqueConstraints= {@UniqueConstraint(columnNames={"email"})})
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    @Column(name = "first_name")
    @NotEmpty(message = "FirstName should not be empty")
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty(message = "Last should not be empty")
    private String lastName;

    @Column(name = "gender")
    @NotEmpty(message = "Gender should not be empty")
    private String gender;

    @Column(name =  "age")
    @NotNull(message = "Age should not be empty")
    private int age;

    @Column(name = "email")
    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;

    @Column(name = "designation")
    @NotEmpty(message = "Designation should not be empty")
    private String designation;

    @Column(name = "hire_date")
    private Date hireDate;

    @Column(name = "resigned_date")
    private Date resignedDate;

    @Column(name = "address")
    private String address;


    @PrePersist
    public void PrePersist(){
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDate.now();
        this.setHireDate(Date.from(localDate.atStartOfDay(defaultZoneId).toInstant()));
    }
}
