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
public class GetIncentiveTypeListResponseDto extends ResponseDto  {
private List<IncentiveTypeResponseDto> incentiveTypeList;

     public GetIncentiveTypeListResponseDto(String code, String message, List<IncentiveTypeResponseDto> incentiveTypeList){
          super(code, message);
          this.incentiveTypeList = incentiveTypeList;
     }
     
     public static ResponseEntity<GetIncentiveTypeListResponseDto> success(List<IncentiveTypeResponseDto> incentiveTypeList) {
          GetIncentiveTypeListResponseDto result = new GetIncentiveTypeListResponseDto(ResponseCode.Success, ResponseMessage.Success, incentiveTypeList);
          return ResponseEntity.status(HttpStatus.OK).body(result);
     }
     
}
