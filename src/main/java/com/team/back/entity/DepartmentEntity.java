package com.team.back.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.team.back.dto.request.system.PutDepartmentInfoRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="department")
@Table(name="department")
public class DepartmentEntity {
  @Id
  private int departmentCode;
  private int companyCode;
  private String departmentName;
  private String departmentStartDate;
  private String departmentEndDate;
  private String departmentTelNumber;
  private String departmentFax;

  public DepartmentEntity(PutDepartmentInfoRequestDto dto) {
    this.departmentCode = dto.getDepartmentCodeInfo();
    this.companyCode = dto.getDepartmentCompanyCode();
    this.departmentName = dto.getDepartmentNameInfo();
    this.departmentStartDate = dto.getDepartmentStartDate();
    this.departmentEndDate = dto.getDepartmentEndDate();
    this.departmentTelNumber = dto.getDepartmentTelNumber();
    this.departmentFax = dto.getDepartmentFax();
  }
}
