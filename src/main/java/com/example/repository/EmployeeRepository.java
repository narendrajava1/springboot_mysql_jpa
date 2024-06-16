package com.example.repository;

import com.example.entity.Employee;
import com.example.model.EmpDTO;
import com.example.model.EmployeeTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("select emp.id as id,emp.address as address,emp.email as email,emp.name as name,emp.department.name as deptName from Employee as emp inner join Department dept on emp.department.id=dept.id where emp.id=:id")
    List<EmployeeTO> findByDeptId(@Param("id")  Integer id);
}