package com.example.model;

import com.example.entity.Department;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class EmpDTO {

    private Long id;

    private String name;

    private String email;

    private String address;
    private String deptName;

    private String desc;
}
