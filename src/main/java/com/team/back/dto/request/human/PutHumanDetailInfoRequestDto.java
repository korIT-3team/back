package com.team.back.dto.request.human;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PutHumanDetailInfoRequestDto {
  @NotNull
  private Integer humanEmployeeCode;
  
  private String employeeImage;

  private String email;

  private String nationality;

  private String address;

  private String addressDetail;

  // @Pattern(regexp = "^\\d{3}-\\d{3}-\\d{4}$")
  private String telNumber;

  private Integer education;

  private Integer militaryService;

  private String career;

  private Integer position;

  private Integer job;

}
