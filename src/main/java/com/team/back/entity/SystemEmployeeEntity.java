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
  private int employeePassword;
  private String employeeRegistration;
  private String employeeEmploymentType;
  private int employeeEmploymentTypeCode;

  public SystemEmployeeEntity(PutSystemEmployeeInfoRequestDto dto) {
    this.employeeCode = dto.getSystemEmployeeCode();
    this.employeeName = dto.getSystemEmployeeName();
    this.employeeGender = dto.getSystemEmployeeGender();
    this.employeeGenderCode = dto.getSystemEmployeeGenderCode();
    this.employeeDepartmentName = dto.getSystemEmployeeDepartmentName();
    this.employeeDepartmentCode = dto.getSystemEmployeeDepartmentCode();
    this.employeeJoinDate = dto.getSystemEmployeeJoinDate();
    this.employeeResignationDate = dto.getSystemEmployeeResignationDate();
    this.employeePassword = dto.getSystemEmployeePassword();
    this.employeeRegistration = dto.getSystemEmployeeRegistration();
    this.employeeEmploymentType = dto.getSystemEmployeeEmploymentType();
    this.employeeEmploymentTypeCode = dto.getSystemEmployeeEmploymentTypeCode();
  }

}
