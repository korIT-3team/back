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
public class GetSalesPlanListResponseDto extends ResponseDto {

  private List<SalesPlanListResponseDto> salesPlanList;

  private GetSalesPlanListResponseDto(String code, String message, List<SalesPlanListResponseDto> salesPlanList) {
    super(code, message);
    this.salesPlanList = salesPlanList;
  }

  public static ResponseEntity<GetSalesPlanListResponseDto> success(List<SalesPlanListResponseDto> salesPlanList) {
    GetSalesPlanListResponseDto result = new GetSalesPlanListResponseDto(ResponseCode.Success, ResponseMessage.Success, salesPlanList);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  public static ResponseEntity<ResponseDto> noExistedSalesPlan() {
    ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_SALES_PLAN, ResponseMessage.NO_EXISTED_SALE_PLAN);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }
}
