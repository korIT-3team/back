package com.team.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.team.back.entity.SystemEmployeeEntity;
import com.team.back.entity.resultSets.SystemEmployeeListResultSet;

@Repository
public interface SystemEmployeeRepository  extends JpaRepository<SystemEmployeeEntity, Integer>  {

    boolean existsByEmployeeName(String employeeName);
    boolean existsByRegistrationNumber(String registrationNumber);

    SystemEmployeeEntity findByEmployeeCode(Integer employeeCode);
    SystemEmployeeEntity findByRegistrationNumber(String registrationNumber);


  @Query(
      value=
      "SELECT ROW_NUMBER() OVER(ORDER BY E.employee_code) AS no, " + 
      "E.employee_code AS employeeCode, " +
      "E.employee_name AS employeeName, " +
      "UD1.user_define_detail_name AS employeeGender, " +
      "E.gender_code AS employeeGenderCode, " +
      "D.department_name AS employeeDepartmentName, " +
      "E.department_code AS employeeDepartmentCode, " +
      "E.join_date AS employeeJoinDate, " +
      "E.resignation_date AS employeeResignationDate, " +
      "E.password AS employeePassword, " +
      "E.registration_number AS employeeRegistrationNumber, " +
      "UD2.user_define_detail_name AS employeeEmploymentType, " +
      "E.employment_type AS employeeEmploymentTypeCode " +
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
