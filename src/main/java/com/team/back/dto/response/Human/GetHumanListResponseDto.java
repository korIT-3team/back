package com.team.back.dto.response.Human;

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
public class GetHumanListResponseDto extends ResponseDto {

  private List<HumanListResponseDto> humanList;

  private GetHumanListResponseDto(String code, String message, List<HumanListResponseDto> humanList) {
    super(code, message);
    this.humanList = humanList;
  }

  public static ResponseEntity<GetHumanListResponseDto> success(List<HumanListResponseDto> humanList){
    GetHumanListResponseDto result = new GetHumanListResponseDto(ResponseCode.Success, ResponseMessage.Success, humanList);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  public static ResponseEntity<ResponseDto> noExistedHumanInfo() {
    ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_HUMAN_INFO, ResponseMessage.NO_EXISTED_HUMAN_INFO);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }
  
}
