package com.team.back.dto.response.human;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.response.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeleteIncentiveInfoResponseDto extends ResponseDto {
  private DeleteIncentiveInfoResponseDto(String code, String message) {
    super(code, message);
  }

  public static ResponseEntity<DeleteIncentiveInfoResponseDto> success() {
    DeleteIncentiveInfoResponseDto result = new DeleteIncentiveInfoResponseDto(ResponseCode.Success, ResponseMessage.Success);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  public static ResponseEntity<ResponseDto> noExistedUser() {
    ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_USER, ResponseMessage.NO_EXISTED_USER);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }

  public static ResponseEntity<ResponseDto> noExistedIncentiveInfo() {
    ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_INCENTIVE_INFO, ResponseMessage.NO_EXISTED_INCENTIVE_INFO);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }

  public static ResponseEntity<ResponseDto> noPermission() {
    ResponseDto result = new ResponseDto(ResponseCode.NO_PERMISSION, ResponseMessage.NO_PERMISSION);
    return ResponseEntity.status(HttpStatus.FORBIDDEN).body(result);
  }
}
