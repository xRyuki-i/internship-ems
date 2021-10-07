package com.internship.ems.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "salary", schema = "ems")
@Data
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long salaryId;

    @Column(name = "issue_date")
    @NotNull
    Date issueDate;

    @Column(name = "amount")
    @NotEmpty(message = "Amount shouldn't be left empty")
    float amount;

    @Column(name = "bonus")
    float bonus;

    @PreRemove
    public void PreRemove(){
        System.out.println("Entity "+this+" will be removed.");
    }

    @PostRemove
    public void PostRemove(){
        System.out.println("Entity "+this+" was removed.");
    }
}
