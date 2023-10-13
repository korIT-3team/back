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
public class PutDepartmentInfoResponseDto extends ResponseDto {

  private PutDepartmentInfoResponseDto (String code, String message) {
    super(code, message);
  }

  public static ResponseEntity<PutDepartmentInfoResponseDto> success() {
    PutDepartmentInfoResponseDto result = new PutDepartmentInfoResponseDto(ResponseCode.Success, ResponseMessage.Success);
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

  public static ResponseEntity<ResponseDto> noExistedDepartmentCode() {
    ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_DEPARTMENT_CODE, ResponseMessage.NO_EXISTED_DEPARTMENT_CODE);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }

  public static ResponseEntity<ResponseDto> existedDeptname() {
    ResponseDto result = new ResponseDto(ResponseCode.EXISTED_DEPARTMENT_NAME, ResponseMessage.EXISTED_DEPARTMENT_NAME);
    return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(result);
  }

  public static ResponseEntity<ResponseDto> existedDeptTelNumber() {
    ResponseDto result = new ResponseDto(ResponseCode.EXISTED_DEPARTMENT_TELNUMBER, ResponseMessage.EXISTED_DEPARTMENT_TELNUMBER);
    return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(result);
  }
  
  public static ResponseEntity<ResponseDto> existedDeptFax() {
    ResponseDto result = new ResponseDto(ResponseCode.EXISTED_DEPARTMENT_FAX, ResponseMessage.EXISTED_DEPARTMENT_FAX);
    return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(result);
  }  
}
