package com.example.entity;

import java.io.Serializable;
import java.util.Set;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "department")
@Data
public class Department implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;
    @OneToMany(targetEntity = Employee.class,mappedBy = "id",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Employee> employess;

}