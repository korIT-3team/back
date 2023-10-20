package com.team.back.entity.resultSets;

public interface OrderInfoListResultSet {
  int getNo();
  int getOrderCode();
  String getOrderDate();
  int getCustomerCode();
  String getCustomerName();
  int getManagerCode();
  String getManagerName();
  int getProductCode();
  String getProductName();
  String getOrderUnit();
  int getOrderQuantity();
  double getOrderPrice();
  double getOrderTotalPrice();

}
