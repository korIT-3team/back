package com.team.back.dto.response.system.Employee;

import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.resultSets.SystemEmployeeListResultSet;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SystemEmployeeListResponseDto {
  private int no;
  private int employeeCode;
  private String employeeName;
  private String gender;
  private int genderCode;
  private String departmentName;
  private int departmentCode;
  private String joinDate;
  private String resignationDate;
  private String password;
  private String registrationNumber;
  private String employmentType;
  private int employmentTypeCode;

  public SystemEmployeeListResponseDto (SystemEmployeeListResultSet resultSet) {
    this.no = resultSet.getNo();
    this.employeeCode = resultSet.getEmployeeCode();    
    this.employeeName = resultSet.getEmployeeName();
    this.gender = resultSet.getEmployeeGender();
    this.genderCode = resultSet.getEmployeeGenderCode();
    this.departmentName = resultSet.getEmployeeDepartmentName();
    this.departmentCode = resultSet.getEmployeeDepartmentCode();
    this.joinDate = resultSet.getEmployeeJoinDate();
    this.resignationDate = resultSet.getEmployeeResignationDate();
    this.password = resultSet.getEmployeePassword();
    this.registrationNumber = resultSet.getEmployeeRegistrationNumber();
    this.employmentType = resultSet.getEmployeeEmploymentType();
    this.employmentTypeCode = resultSet.getEmployeeEmploymentTypeCode();

    }  
  
  public static List<SystemEmployeeListResponseDto> copyList(List<SystemEmployeeListResultSet> resultSets) {
    List<SystemEmployeeListResponseDto> systemEmployeeList = new ArrayList<>();

    for (SystemEmployeeListResultSet resultSet : resultSets) {
      SystemEmployeeListResponseDto systemEmployee = new SystemEmployeeListResponseDto(resultSet);
      systemEmployeeList.add(systemEmployee);
    }

    return systemEmployeeList;
  }

}
