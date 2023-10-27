package com.team.back.dto.response.sales;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.response.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PutSalesPlanInfoResponseDto extends ResponseDto {
  
  private PutSalesPlanInfoResponseDto (String code, String message) {
    super(code, message);
  }

  public static ResponseEntity<PutSalesPlanInfoResponseDto> success() {
    PutSalesPlanInfoResponseDto result = new PutSalesPlanInfoResponseDto(ResponseCode.Success, ResponseMessage.Success);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  public static ResponseEntity<ResponseDto> noPermission() {
    ResponseDto result = new ResponseDto(ResponseCode.NO_PERMISSION, ResponseMessage.NO_PERMISSION);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }

  public static ResponseEntity<ResponseDto> noExistedUser() {
    ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_USER, ResponseMessage.NO_EXISTED_USER);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }

  public static ResponseEntity<ResponseDto> existedProjectName() {
    ResponseDto result = new ResponseDto(ResponseCode.EXISTED_PROJECT_NAME, ResponseMessage.EXISTED_PROJECT_NAME);
    return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(result);
  }


  public static ResponseEntity<ResponseDto> existedSalesPlanCode() {
    ResponseDto result = new ResponseDto(ResponseCode.EXISTED_SALES_PLAN_CODE, ResponseMessage.EXISTED_SALES_PLAN_CODE);
    return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(result);
  }

  public static ResponseEntity<ResponseDto> existedProductCode() {
    ResponseDto result = new ResponseDto(ResponseCode.EXISTED_PRODUCT_CODE, ResponseMessage.EXISTED_PRODUCT_CODE);
    return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(result);
  }

}
