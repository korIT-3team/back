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
public class GetSystemEmpUserDefineInfoResponseDto extends ResponseDto {
 
  private List<SystemEmpUserDefineListResponseDto> systemEmpUserDefineList;

  private GetSystemEmpUserDefineInfoResponseDto(String code, String message, List<SystemEmpUserDefineListResponseDto> systemEmpUserDefineList){
    super(code, message);
    this.systemEmpUserDefineList = systemEmpUserDefineList;
  }

  public static ResponseEntity<GetSystemEmpUserDefineInfoResponseDto> success(List<SystemEmpUserDefineListResponseDto> systemEmpUserDefineList){
    GetSystemEmpUserDefineInfoResponseDto result = new GetSystemEmpUserDefineInfoResponseDto(ResponseCode.Success, ResponseMessage.Success, systemEmpUserDefineList);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  public static ResponseEntity<ResponseDto> noExistedSystemEmployeeInfo() {
    ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_USER_DEFINE_INFO, ResponseMessage.NO_EXISTED_USER_DEFINE_INFO);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }

}
