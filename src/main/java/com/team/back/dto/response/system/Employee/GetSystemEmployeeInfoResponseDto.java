package com.team.back.dto.response.system.Employee;

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
public class GetSystemEmployeeInfoResponseDto extends ResponseDto {
  
  private List<SystemEmployeeListResponseDto> systemEmployeeList;

  private GetSystemEmployeeInfoResponseDto(String code, String message, List<SystemEmployeeListResponseDto> systemEmployeeList){
    super(code, message);
    this.systemEmployeeList = systemEmployeeList;
  }

  public static ResponseEntity<GetSystemEmployeeInfoResponseDto> success(List<SystemEmployeeListResponseDto> systemEmployeeList){
    GetSystemEmployeeInfoResponseDto result = new GetSystemEmployeeInfoResponseDto(ResponseCode.Success, ResponseMessage.Success, systemEmployeeList);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  public static ResponseEntity<ResponseDto> noExistedSystemEmployeeInfo() {
    ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_SYSTEM_EMPLOYEE_INFO, ResponseMessage.NO_EXISTED_SYSTEM_EMPLOYEE_INFO);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }
  
}
