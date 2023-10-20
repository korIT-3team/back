package com.team.back.dto.request.sales;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PutReleaseInfoRequestDto {

  private Integer releaseCode;
  private Integer employeeCode;
  private Integer departmentCode;
  private Integer companyCode;
  private Integer customerCode;
  private String releaseDate;
  private Integer productCode;
  private String productName;
  private Integer orderQuantity;
  private Double productPrice;
  private Double supplyPrice;
  private Double surtax;
  private Double totalPrice;


}
