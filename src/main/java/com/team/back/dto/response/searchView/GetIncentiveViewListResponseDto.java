package com.team.back.dto.response.searchView;

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
public class GetIncentiveViewListResponseDto extends ResponseDto {
     private List<IncentiveViewResponseDto> incentiveViewList;

     private GetIncentiveViewListResponseDto(String code, String message, List<IncentiveViewResponseDto> incentiveViewList){
          super(code, message);
          this.incentiveViewList = incentiveViewList;
     }

     public static ResponseEntity<GetIncentiveViewListResponseDto> success(List<IncentiveViewResponseDto> incentiveViewList){
          GetIncentiveViewListResponseDto result = new GetIncentiveViewListResponseDto(ResponseCode.Success, ResponseMessage.Success, incentiveViewList);
          return ResponseEntity.status(HttpStatus.OK).body(result);
     }
}
