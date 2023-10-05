package com.team.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.team.back.entity.DepartmentEntity;
import com.team.back.entity.resultSets.DepartmentListResultSet;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Integer> {
  boolean existsByDepartmentCode(Integer departmentCode);

  DepartmentEntity findByDepartmentCode(Integer DepartmentCode);

  @Query(
    value=
    "SELECT ROW_NUMBER() OVER(ORDER BY department_code) AS no, " + 
    "department_code AS departmentCode, " + 
    "company_code AS companyCode, " + 
    "department_name AS departmentName, " + 
    "department_start_date AS departmentStartDate, " + 
    "department_end_date AS departmentEndDate, " + 
    "department_tel_number AS departmentTelnumber, " + 
    "department_fax AS departmentFax " + 
    "FROM department AS D " + 
    "WHERE department_code != 9999 " + 
    "ORDER BY department_code ",
    
    nativeQuery = true
  )
  List<DepartmentListResultSet> getDepartmentList();
  // List<DepartmentListResultSet> findbyDepartmentList(String departmentName);
}
