package com.team.back.dto.request.system;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PutSystemEmployeeInfoRequestDto {
  @NotNull
  private Integer employeeCode;

  @NotBlank
  private String employeeName;

  @NotBlank
  private String employeeGender;
  
  @NotNull
  private Integer employeeGenderCode;

  @NotBlank
  private String employeeDepartmentName;
  
  @NotNull
  private Integer employeeDepartmentCode;

  @NotBlank
  private String employeeJoinDate;

  private String employeeResignationDate;

  @NotBlank
  private String employeePassword;

  @NotBlank @Pattern(regexp = "^[\\d]{6}-[1-4][\\d]{6}+$")
  private String employeeRegistrationNumber;

  @NotBlank
  private String employeeEmploymentType;

  @NotNull
  private Integer employeeEmploymentTypeCode;

}
