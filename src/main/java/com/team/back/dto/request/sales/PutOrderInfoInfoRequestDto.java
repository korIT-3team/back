package com.team.back.dto.request.sales;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PutOrderInfoInfoRequestDto {

  @NotNull
  private Integer orderCodeInfo;

  private Integer orderInfoSalesPlanCode;

  private Integer orderInfoCompanyCode = 1;
  
  private Integer orderInfoCustomerCode;
  
  private String orderDate;
  
  private Integer orderInfoManagerCode;
  
  private String orderDetail;
  
  private Integer orderInfoproductCode;
  
  private String orderInfoProductName;
  
  private String orderUnit;
  
  private Integer orderQuantity;
  
  private Double orderPrice;
  
  private Double orderTotalPrice;
  
}
