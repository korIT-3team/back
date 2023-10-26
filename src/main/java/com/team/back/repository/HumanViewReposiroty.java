package com.team.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.team.back.entity.EmployeeViewEntity;

@Repository
public interface HumanViewReposiroty extends JpaRepository<EmployeeViewEntity, Integer>  {
     @Query(
          value=
               "SELECT * " +
               "FROM employee_list_view " +
               "WHERE (?2 = 0 OR (employee_code   != 0 AND employee_code   = ?2)) " +
                 "AND (?1 = 0 OR (department_code != 0 AND department_code = ?1))" +
                 "AND (?3 = 0 OR (employment_code != 0 AND employment_code = ?3));",
               nativeQuery=true 
     )
     List<EmployeeViewEntity> getHumanViewList(String departmentCode, String employeeCode, String employmentType);
     
}
