package com.team.back.dto.response.system;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.response.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PutSystemEmployeeInfoResponseDto extends ResponseDto {

  private PutSystemEmployeeInfoResponseDto (String code, String message) {
    super(code, message);
  }

  public static ResponseEntity<PutSystemEmployeeInfoResponseDto> success() {
    PutSystemEmployeeInfoResponseDto result = new PutSystemEmployeeInfoResponseDto(ResponseCode.Success, ResponseMessage.Success);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  public static ResponseEntity<ResponseDto> noPermission() {
    ResponseDto result = new ResponseDto(ResponseCode.NO_PERMISSION, ResponseMessage.NO_PERMISSION);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }

  public static ResponseEntity<ResponseDto> noExistedUser() {
    ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_USER, ResponseMessage.NO_EXISTED_USER);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  } 

  public static ResponseEntity<ResponseDto> noExistedSystemEmployeeCode() {
    ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_SYSTEM_EMPLOYEE_INFO, ResponseMessage.NO_EXISTED_SYSTEM_EMPLOYEE_INFO);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }

  public static ResponseEntity<ResponseDto> existedSystemEmployeeName() {
    ResponseDto result = new ResponseDto(ResponseCode.EXISTED_SYSTEM_EMPLOYEE_NAME, ResponseMessage.EXISTED_SYSTEM_EMPLOYEE_NAME);
    return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(result);
  }

  public static ResponseEntity<ResponseDto> existedSystemEmployeeRegistrationNumber() {
    ResponseDto result = new ResponseDto(ResponseCode.EXISTED_SYSTEM_EMPLOYEE_REGISTRATION_NUMBER, ResponseMessage.EXISTED_SYSTEM_EMPLOYEE_REGISTRATION_NUMBER);
    return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(result);
  }
}
