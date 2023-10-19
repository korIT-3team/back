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
@Entity(name="employee")
@Table(name="employee")
public class SystemEmployeeEntity {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int employeeCode;
  private String employeeName;
  private int genderCode;
  private int departmentCode;
  private String joinDate;
  private String resignationDate;
  private String password;
  private String registrationNumber;
  private int employmentType;
  private String employeeImage;
  private String email;
  private String nationality;
  private String address;
  private String addressDetail;
  private String telNumber;
  private int education;
  private int militaryService;
  private int position;

  public SystemEmployeeEntity(PutSystemEmployeeInfoRequestDto dto) {
    this.employeeCode = dto.getSysEmployeeCode();
    this.employeeName = dto.getEmployeeName();
    this.genderCode = dto.getGenderCode();
    this.departmentCode = dto.getEmpDepartmentCode();
    this.joinDate = dto.getJoinDate();
    this.resignationDate = dto.getResignationDate();
    this.password = dto.getPassword();
    this.registrationNumber = dto.getRegistrationNumber();
    this.employmentType = dto.getEmploymentTypeCode();
  }

}