package com.team.back.dto.response.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.response.ResponseDto;
import com.team.back.entity.Oauth.OAuth2UserEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class KakaoSignInResponseDto extends ResponseDto {

     public KakaoSignInResponseDto(String code, String message){
          super(code, message);
     }
     
     public static ResponseEntity<KakaoSignInResponseDto> success() {
          KakaoSignInResponseDto result = new KakaoSignInResponseDto(ResponseCode.Success, ResponseMessage.Success);
          return ResponseEntity.status(HttpStatus.OK).body(result);
     }

     public static ResponseEntity<ResponseDto> NotMatchedId() {
          ResponseDto result = new ResponseDto(ResponseCode.NOT_MATCHED_ID, ResponseMessage.NOT_MATCHED_ID);
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
     }
}
