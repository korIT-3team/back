package com.team.back.dto.response.sales;

import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.resultSets.OrderInfoListResultSet;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderInfoListResponseDto {
  
  private int no;
  private int orderCode;
  private String orderDate;
  private int customerCode;
  private int managerCode;
  private int productCode;
  private String productName;
  private String orderUnit;
  private int orderQuantity;
  private double orderPrice;
  private double orderTotalPrice;

  public OrderInfoListResponseDto (OrderInfoListResultSet resultSet) {
    this.no = resultSet.getNo();
    this.orderCode = resultSet.getOrderCode();
    this.orderDate = resultSet.getOrderDate();
    this.customerCode = resultSet.getCustomerCode();
    this.managerCode = resultSet.getManagerCode();
    this.productCode = resultSet.getProductCode();
    this.productName = resultSet.getProductName();
    this.orderUnit = resultSet.getOrderUnit();
    this.orderQuantity = resultSet.getOrderQuantity();
    this.orderPrice = resultSet.getOrderPrice();
    this.orderTotalPrice = resultSet.getOrderTotalPrice();
  }

  public static List<OrderInfoListResponseDto> copyList(List<OrderInfoListResultSet> resultSets) {
    List<OrderInfoListResponseDto> orderInfoList = new ArrayList<>();

    for (OrderInfoListResultSet resultSet: resultSets) {
      OrderInfoListResponseDto orderInfo = new OrderInfoListResponseDto(resultSet);
      orderInfoList.add(orderInfo);
    }

    return orderInfoList;
  }


}
