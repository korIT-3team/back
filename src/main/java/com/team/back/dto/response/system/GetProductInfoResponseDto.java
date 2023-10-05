package com.team.back.dto.response.system;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.response.ResponseDto;
import com.team.back.entity.ProductEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetProductInfoResponseDto extends ResponseDto {
  private int companyCode;
  private int productCode;
  private String productName;
  private int procurementCategory;
  private double productPrice;

  private GetProductInfoResponseDto(String code, String message, ProductEntity productEntity) {
    super(code, message);
    this.companyCode = productEntity.getCompanyCode();
    this.productCode = productEntity.getProductCode();
    this.productName = productEntity.getProductName();
    this.procurementCategory = productEntity.getProcurementCategory();
    this.productPrice = productEntity.getProductPrice();
  }

  public static ResponseEntity<GetProductInfoResponseDto> success(ProductEntity productEntity) {
    GetProductInfoResponseDto result = new GetProductInfoResponseDto(ResponseCode.Success, ResponseMessage.Success, productEntity);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  public static ResponseEntity<ResponseDto> noExistedProductInfo() {
    ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_PRODUCT_INFO, ResponseMessage.NO_EXISTED_PRODUCT_INFO);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }

}
