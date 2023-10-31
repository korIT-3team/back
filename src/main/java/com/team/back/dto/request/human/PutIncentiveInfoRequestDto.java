package com.team.back.dto.request.human;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PutIncentiveInfoRequestDto {
  @NotNull
  private Integer incentiveCode;

  @NotNull
  private Integer incentiveEmployeeCode;

  @NotNull
  private Integer incentiveCategory;

  @NotBlank
  private String paymentDate;

  @NotNull
  private double incentivePrice;

  private String content;

}