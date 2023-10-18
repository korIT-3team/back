package com.team.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.team.back.entity.EmployeeViewEntity;

@Repository
public interface EmployeeViewRepository extends JpaRepository<EmployeeViewEntity, Integer>  {
     @Query(
          value=
               "SELECT * " +
               "from employee_list_view " +
               "where employee_code LIKE %?2% " +
               "AND department_code LIKE %?1% " +
               "AND employment_type LIKE %?3%; ",
               nativeQuery=true 
     )
     List<EmployeeViewEntity> getEmployeeViewList(String departmentCode, String employeeCode, String employmentType);
     
}
