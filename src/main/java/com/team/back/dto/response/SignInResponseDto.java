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

     
     private SignInResponseDto (String code, String message) {
          super(code, message);
     }
        
     public static ResponseEntity<SignInResponseDto> success() {
          SignInResponseDto result = new SignInResponseDto(ResponseCode.Success, ResponseMessage.Success);
          return ResponseEntity.status(HttpStatus.OK).body(result);
     }
}
