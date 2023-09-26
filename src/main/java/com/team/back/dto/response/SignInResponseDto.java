package com.team.back.dto.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignInResponseDto extends ResponseDto{
     private int employeeCode;
     
     private SignInResponseDto (String code, String message, Integer employeeCode) {
          super(code, message);
          this.employeeCode = employeeCode;
     }
        
     public static ResponseEntity<SignInResponseDto> success(Integer employeeCode) {
          SignInResponseDto result = new SignInResponseDto(ResponseCode.Success, ResponseMessage.Success, employeeCode);
          return ResponseEntity.status(HttpStatus.OK).body(result);
     }
}
