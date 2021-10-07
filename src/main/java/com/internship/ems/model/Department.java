package com.internship.ems.model;

import ch.qos.logback.core.net.SyslogOutputStream;
import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "department", schema = "ems")
@Data

public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long  departmentId;

    @Column(name = "name")
    @NotBlank(message="Please enter a valid name")
    String name;

    @Column(name = "description")
    String description = "none";

    @PreRemove
    public void PreRemove(){
        System.out.println("Entity "+this+" will be removed.");
    }

    @PostRemove
    public void PostRemove(){
        System.out.println("Entity "+this+" was removed.");
    }
}
