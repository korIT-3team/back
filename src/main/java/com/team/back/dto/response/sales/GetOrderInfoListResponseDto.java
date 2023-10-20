package com.team.back.dto.response.sales;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.response.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetOrderInfoListResponseDto extends ResponseDto {

  private List<OrderInfoListResponseDto> orderInfoList;

  private GetOrderInfoListResponseDto(String code, String messsage, List<OrderInfoListResponseDto> orderInfoList) {
    super(code, messsage);
    this.orderInfoList = orderInfoList;
  }

  public static ResponseEntity<GetOrderInfoListResponseDto> success(List<OrderInfoListResponseDto> orderInfoList) {
    GetOrderInfoListResponseDto result = new GetOrderInfoListResponseDto(ResponseCode.Success, ResponseMessage.Success, orderInfoList);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  public static ResponseEntity<ResponseDto> noExistedOrderInfo() {
    ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_ORDER_INFO, ResponseMessage.NO_EXISTED_ORDER_INFO);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }
  
}
