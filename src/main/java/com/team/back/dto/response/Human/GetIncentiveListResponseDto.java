package com.team.back.dto.response.human;

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
public class GetIncentiveListResponseDto extends ResponseDto {

  private List<IncentiveListResponseDto> incentiveList;

  private GetIncentiveListResponseDto(String code, String message, List<IncentiveListResponseDto> incentiveList) {
    super(code, message);
    this.incentiveList = incentiveList;
  }

  public static ResponseEntity<GetIncentiveListResponseDto> success(List<IncentiveListResponseDto> incentiveList){
    GetIncentiveListResponseDto result = new GetIncentiveListResponseDto(ResponseCode.Success, ResponseMessage.Success, incentiveList);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  public static ResponseEntity<ResponseDto> noExistedIncentiveInfo() {
    ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_INCENTIVE_INFO, ResponseMessage.NO_EXISTED_INCENTIVE_INFO);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }
  
}
