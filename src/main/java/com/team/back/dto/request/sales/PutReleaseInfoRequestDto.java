package com.team.back.dto.request.sales;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PutReleaseInfoRequestDto {

  @NotNull
  private Integer releaseCodeInfo;

  @NotNull
  private Integer employeeCodeInfo;

  @NotNull
  private Integer departmentCodeInfo;

  @NotNull
  private Integer companyCodeInfo = 1;

  @NotNull
  private Integer customerCodeInfo;

  @NotNull
  private String releaseDate;

  @NotNull
  private Integer productCode;

  private String productName;
  
  @NotNull
  private Integer orderQuantity;
  
  @NotNull
  private Double productPrice;
  
  @NotNull
  private Double supplyPrice;
  
  private Double surtax;
  
  private Double totalPrice;


}
