package com.team.back.dto.response.accounting;

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
public class GetInOutComeListResponseDto extends ResponseDto{
     private List<InOutComeResponseDto> inOutComeList;

     private GetInOutComeListResponseDto(String code, String message, List<InOutComeResponseDto> inOutComeList){
          super(code, message);
          this.inOutComeList = inOutComeList;
     }

     public static ResponseEntity<GetInOutComeListResponseDto> success(List<InOutComeResponseDto> inOutComeList){
          GetInOutComeListResponseDto result = new GetInOutComeListResponseDto(ResponseCode.Success, ResponseMessage.Success, inOutComeList);
          return ResponseEntity.status(HttpStatus.OK).body(result);
     }
}
