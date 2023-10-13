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
public class GetFundsListResponseDto extends ResponseDto{
     private List<FundsResponseDto> fundsList;

     private GetFundsListResponseDto(String code, String message, List<FundsResponseDto> fundsList){
          super(code, message);
          this.fundsList = fundsList;
     }

     public static ResponseEntity<GetFundsListResponseDto> success(List<FundsResponseDto> fundsList){
          GetFundsListResponseDto result = new GetFundsListResponseDto(ResponseCode.Success, ResponseMessage.Success, fundsList);
          return ResponseEntity.status(HttpStatus.OK).body(result);
     }
}
