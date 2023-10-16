package com.team.back.dto.response.system.Employee;

import java.util.ArrayList;
import java.util.List;

import com.team.back.dto.response.system.DepartmentListResponseDto;
import com.team.back.entity.resultSets.DepartmentListResultSet;
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
    this.employeeCode = resultSet.getSystemEmployeeCode();    
    this.employeeName = resultSet.getSystemEmployeeName();
    this.gender = resultSet.getSystememployeeGender();
    this.genderCode = resultSet.getSystemEmployeeGenderCode();
    this.departmentName = resultSet.getSystemEmployeeDepartmentName();
    this.departmentCode = resultSet.getSystemEmployeeDepartmentCode();
    this.joinDate = resultSet.getSystemEmployeeJoinDate();
    this.resignationDate = resultSet.getSystemEmployeeResignationDate();
    this.password = resultSet.getSystemEmployeePassword();
    this.registrationNumber = resultSet.getSystemEmployeeRegistrationNumber();
    this.employmentType = resultSet.getSystemEmployeeEmploymentType();
    this.employmentTypeCode = resultSet.getSystemEmployeeEmploymentTypeCode();

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
