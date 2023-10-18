package com.team.back.dto.response.system;

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
public class GetProductInfoResponseDto extends ResponseDto {
  
  private List<ProductListResponseDto> productList;

  private GetProductInfoResponseDto(String code, String message, List<ProductListResponseDto> productList) {
    super(code, message);
    this.productList = productList;
  }

  public static ResponseEntity<GetProductInfoResponseDto> success(List<ProductListResponseDto> productList) {
    GetProductInfoResponseDto result = new GetProductInfoResponseDto(ResponseCode.Success, ResponseMessage.Success, productList);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  public static ResponseEntity<ResponseDto> noExistedProductInfo() {
    ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_PRODUCT_INFO, ResponseMessage.NO_EXISTED_PRODUCT_INFO);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }

}
