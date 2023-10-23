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
  private Integer sysEmployeeCode;

  @NotBlank
  private String employeeName;

  @NotNull
  private Integer genderCode;

  @NotNull
  private Integer empDepartmentCode;

  @NotBlank
  private String joinDate;

  private String resignationDate;

  private String password;

  @NotBlank @Pattern(regexp = "^[\\d]{6}-[1-4][\\d]{6}+$")
  private String registrationNumber;

  @NotNull
  private Integer employmentTypeCode;

}