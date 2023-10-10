package com.team.back.dto.request.system;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.UniqueElements;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PutDepartmentInfoRequestDto {
  
  @NotNull
  private Integer departmentCodeInfo;
  @NotNull
  private Integer departmentCompanyCode = 1;

  @NotBlank
  private String departmentNameInfo;

  @NotBlank
  private String departmentStartDate;
  
  private String departmentEndDate;

  @NotBlank
  private String departmentTelNumber;

  @NotBlank
  private String departmentFax;

}
