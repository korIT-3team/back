package com.team.back.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.team.back.dto.request.system.PutSystemEmployeeInfoRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="system_employee")
@Table(name="employee")
public class SystemEmployeeEntity {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int employeeCode;
  private String employeeName;
  private String employeeGender;
  private int employeeGenderCode;
  private String employeeDepartmentName;
  private int employeeDepartmentCode;
  private String employeeJoinDate;
  private String employeeResignationDate;
  private String employeePassword;
  private String employeeRegistrationNumber;
  private String employeeEmploymentType;
  private int employeeEmploymentTypeCode;

  public SystemEmployeeEntity(PutSystemEmployeeInfoRequestDto dto) {
    this.employeeCode = dto.getEmployeeCode();
    this.employeeName = dto.getEmployeeName();
    this.employeeGender = dto.getEmployeeGender();
    this.employeeGenderCode = dto.getEmployeeGenderCode();
    this.employeeDepartmentName = dto.getEmployeeDepartmentName();
    this.employeeDepartmentCode = dto.getEmployeeDepartmentCode();
    this.employeeJoinDate = dto.getEmployeeJoinDate();
    this.employeeResignationDate = dto.getEmployeeResignationDate();
    this.employeePassword = dto.getEmployeePassword();
    this.employeeRegistrationNumber = dto.getEmployeeRegistrationNumber();
    this.employeeEmploymentType = dto.getEmployeeEmploymentType();
    this.employeeEmploymentTypeCode = dto.getEmployeeEmploymentTypeCode();
  }

}
