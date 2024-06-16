package com.example.controller;

import com.example.entity.Employee;
import com.example.model.DeptEmpDto;
import com.example.model.EmpDTO;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/empAndDept")
    public List<DeptEmpDto> getEmpAndDeptByEmpId(@RequestParam(name = "id") Integer id){
        return employeeService.getEmployeeAndDeptByEmpId(id);
    }

    @PostMapping("/create")
    public String saveEmp(@RequestBody EmpDTO empDTO){
       return  employeeService.saveEmp(empDTO);
    }
}
