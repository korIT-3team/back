package com.team.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.team.back.entity.DepartmentEntity;
import com.team.back.entity.resultSets.SystemEmployeeListResultSet;

@Repository
public interface SystemEmployeeRepository  extends JpaRepository<DepartmentEntity, Integer>  {
  @Query(
      value=
      "SELECT ROW_NUMBER() OVER(ORDER BY E.employee_code) AS no, " + 
      "E.employee_code AS systemEmployeeCode, " +
      "E.employee_name AS systemEmployeeName, " +
      "UD1.user_define_detail_name AS systemEmployeeGender, " +
      "E.gender_code AS systemEmployeeGenderCode, " +
      "D.department_name AS systemEmployeeDepartmentName, " +
      "E.department_code AS systemEmployeeDepartmentCode, " +
      "E.join_date AS systemEmployeeJoinDate, " +
      "E.password AS systemEmployeePassword, " +
      "E.registration_number AS systemEmployeeRegistrationNumber, " +
      "UD2.user_define_detail_name AS systemEmployeeEmploymentType, " +
      "E.employment_type AS systemEmployeeEmploymentTypeCode " +
      "FROM employee AS E " +
      "LEFT OUTER JOIN user_define_detail AS UD1 ON E.gender_code = UD1.user_define_detail_code AND UD1.user_define_code = 9011 " +
      "LEFT OUTER JOIN department AS D ON D.department_code = E.department_code " +
      "LEFT OUTER JOIN user_define_detail AS UD2 ON E.employment_type = UD2.user_define_detail_code AND UD2.user_define_code = 9003 " +
      "WHERE E.employee_code != 2999 " +
      "AND employee_name LIKE %?1% " +
      "ORDER BY E.employee_code; ",
      
      nativeQuery = true
  )

  List<SystemEmployeeListResultSet> getSystemEmployeeList(String systemEmployeeName);
}