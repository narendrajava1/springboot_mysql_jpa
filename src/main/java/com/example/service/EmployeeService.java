package com.example.service;

import com.example.entity.Department;
import com.example.entity.Employee;
import com.example.model.DeptEmpDto;
import com.example.model.EmpDTO;
import com.example.model.EmployeeTO;
import com.example.repository.DepartmentRepository;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<DeptEmpDto> getEmployeeAndDeptByEmpId(Integer id){
        List<EmployeeTO> employeeList = employeeRepository.findByDeptId(id);
        return employeeList.stream().map(employee -> {
            DeptEmpDto deptEmpDto = new DeptEmpDto(employee.getDeptName(), employee.getName(), employee.getEmail(), employee.getAddress());

            return deptEmpDto;
        }).collect(Collectors.toList());
    }

    public String saveEmp(EmpDTO empDTO){
        Employee employee=new Employee();
        employee.setAddress(empDTO.getAddress());
        employee.setName(empDTO.getName());
        employee.setEmail(empDTO.getEmail());
        Department department=new Department();
        department.setName(empDTO.getDeptName());
        department.setDescription(empDTO.getDesc());
        departmentRepository.save(department);
        employee.setDepartment(department);
        employeeRepository.save(employee);
        return employee.getName();
    }
}
