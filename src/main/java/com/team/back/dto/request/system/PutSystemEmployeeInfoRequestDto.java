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
  private Integer systemEmployeeCode;

  @NotBlank
  private String systemEmployeeName;

  @NotBlank
  private String systemEmployeeGender;
  
  @NotNull
  private Integer systemEmployeeGenderCode;

  @NotBlank
  private String systemEmployeeDepartmentName;
  
  @NotNull
  private Integer systemEmployeeDepartmentCode;

  @NotBlank
  private String systemEmployeeJoinDate;

  private String systemEmployeeResignationDate;

  @NotBlank
  private Integer systemEmployeePassword;

  @NotBlank @Pattern(regexp = "^[\\d]{6}-[1-4][\\d]{6}+$")
  private String systemEmployeeRegistration;

  @NotBlank
  private String systemEmployeeEmploymentType;

  @NotNull
  private Integer systemEmployeeEmploymentTypeCode;

}
