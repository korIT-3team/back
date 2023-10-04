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
  
}
