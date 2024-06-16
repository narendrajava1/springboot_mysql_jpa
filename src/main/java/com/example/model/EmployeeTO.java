package com.example.model;

import lombok.Data;
import lombok.Getter;


public interface EmployeeTO {

    Long getId();


    String getName();

    String getEmail();

    String getAddress();

    String getDeptName();

    String getDesc();


}
