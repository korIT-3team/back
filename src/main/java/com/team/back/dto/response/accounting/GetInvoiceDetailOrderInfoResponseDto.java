package com.team.back.dto.response.accounting;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.response.ResponseDto;
import com.team.back.entity.OrderViewEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetInvoiceDetailOrderInfoResponseDto extends ResponseDto {
     private Integer orderCode;
     private String orderDate;
     private Double orderPrice;
     private String orderDetail;
     private Integer salesPlanCode;
     private Integer customerCode;
     private String employeeName;
     private String customerName;
     
     public GetInvoiceDetailOrderInfoResponseDto(String code, String message, OrderViewEntity orderViewEntity){
          super(code, message);
          this.orderCode = orderViewEntity.getOrderCode();
          this.orderDate = orderViewEntity.getOrderDate();
          this.orderPrice = orderViewEntity.getOrderPrice();
          this.orderDetail = orderViewEntity.getOrderDetail();
          this.salesPlanCode = orderViewEntity.getSalesPlanCode();
          this.customerCode = orderViewEntity.getCustomerCode();
          this.employeeName = orderViewEntity.getEmployeeName();
          this.customerName = orderViewEntity.getCustomerName();
     }

     public static ResponseEntity<GetInvoiceDetailOrderInfoResponseDto> success(OrderViewEntity orderViewEntity) {
          GetInvoiceDetailOrderInfoResponseDto result = new GetInvoiceDetailOrderInfoResponseDto(ResponseCode.Success, ResponseMessage.Success, orderViewEntity);
          return ResponseEntity.status(HttpStatus.OK).body(result);
     }
     
     public static ResponseEntity<ResponseDto> noExistedInvoice() {
          ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_INVOICE, ResponseMessage.NO_EXISTED_INVOICE);
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
     }
}
