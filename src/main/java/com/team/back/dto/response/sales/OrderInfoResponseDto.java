package com.team.back.dto.response.sales;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.response.ResponseDto;
import com.team.back.entity.OrderInfoEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderInfoResponseDto extends ResponseDto {
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

  public OrderInfoResponseDto(String code, String message, OrderInfoEntity orderInfoEntity) {
    super(code, message);
    this.orderCode = orderInfoEntity.getOrderCode();
    this.orderDate = orderInfoEntity.getOrderDate();
    this.customerCode = orderInfoEntity.getCustomerCode();
    this.managerCode = orderInfoEntity.getManagerCode();
    this.productCode = orderInfoEntity.getProductCode();
    this.productName = orderInfoEntity.getProductName();
    this.orderUnit = orderInfoEntity.getOrderUnit();
    this.orderQuantity = orderInfoEntity.getOrderQuantity();
    this.orderPrice = orderInfoEntity.getOrderPrice();
    this.orderTotalPrice = orderInfoEntity.getOrderTotalPrice();
  }

  public OrderInfoResponseDto(OrderInfoEntity orderInfoEntity) {

    this.orderCode = orderInfoEntity.getOrderCode();
    this.orderDate = orderInfoEntity.getOrderDate();
    this.customerCode = orderInfoEntity.getCustomerCode();
    this.managerCode = orderInfoEntity.getManagerCode();
    this.productCode = orderInfoEntity.getProductCode();
    this.productName = orderInfoEntity.getProductName();
    this.orderUnit = orderInfoEntity.getOrderUnit();
    this.orderQuantity = orderInfoEntity.getOrderQuantity();
    this.orderPrice = orderInfoEntity.getOrderPrice();
    this.orderTotalPrice = orderInfoEntity.getOrderTotalPrice();

  }

  public static List<OrderInfoResponseDto> copyEntityList(List<OrderInfoEntity> orderInfoEntities) {
    List<OrderInfoResponseDto> orderInfoList = new ArrayList<>();

    for(OrderInfoEntity orderInfoEntity: orderInfoEntities) {
      OrderInfoResponseDto orderInfoItem = new OrderInfoResponseDto(orderInfoEntity);
      orderInfoList.add(orderInfoItem);
    }

    return orderInfoList;
  }

  public static ResponseEntity<OrderInfoResponseDto> success(OrderInfoEntity orderInfoEntity) {
    OrderInfoResponseDto result = new OrderInfoResponseDto(ResponseCode.Success, ResponseMessage.Success, orderInfoEntity);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  public static ResponseEntity<ResponseDto> noExistedOrderInfo() {
    ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_ORDER_INFO, ResponseMessage.NO_EXISTED_ORDER_INFO);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }
}
