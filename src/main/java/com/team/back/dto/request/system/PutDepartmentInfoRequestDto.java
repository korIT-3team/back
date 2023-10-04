package com.team.back.dto.request.system;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.UniqueElements;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PutDepartmentInfoRequestDto {
  private int no;
  
  @NotBlank
  private int companyCode;

  @NotBlank
  private int departmentCode;

  @NotBlank
  @UniqueElements
  private String departmentName;

  @NotBlank
  private String departmentStartDate;
  
  private String departmentEndDate;

  @NotBlank
  @UniqueElements
  private String departmetTelnumber;

  @NotBlank
  @UniqueElements
  private String departmentFax;

}
