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
public class DeleteSalesPlanInfoResponseDto extends ResponseDto {
  private DeleteSalesPlanInfoResponseDto(String code, String message) {
    super(code, message);
  }

  public static ResponseEntity<DeleteSalesPlanInfoResponseDto> success() {
    DeleteSalesPlanInfoResponseDto result = new DeleteSalesPlanInfoResponseDto(ResponseCode.Success, ResponseMessage.Success);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  public static ResponseEntity<ResponseDto> noExistedUser() {
    ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_USER, ResponseMessage.NO_EXISTED_USER);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }

  public static ResponseEntity<ResponseDto> noExistSalesPlanInfo() {
    ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_SALES_PLAN, ResponseMessage.NO_EXISTED_SALE_PLAN);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }

  public static ResponseEntity<ResponseDto> noPermission() {
    ResponseDto result = new ResponseDto(ResponseCode.NO_PERMISSION, ResponseMessage.NO_PERMISSION);
    return ResponseEntity.status(HttpStatus.FORBIDDEN).body(result);
  }
  
}
