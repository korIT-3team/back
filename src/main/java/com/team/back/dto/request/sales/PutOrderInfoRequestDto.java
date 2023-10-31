package com.team.back.dto.request.sales;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PutOrderInfoRequestDto {
  @NotNull
  private Integer orderCode;
  @NotNull
  private Integer salesPlanCode;
  @NotNull
  private Integer customerCode;
  @NotBlank
  private String orderDate;
  @NotNull
  private Integer managerCode;
}
