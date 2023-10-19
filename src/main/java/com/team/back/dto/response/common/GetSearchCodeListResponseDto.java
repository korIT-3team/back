package com.team.back.dto.response.common;

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
public class GetSearchCodeListResponseDto extends ResponseDto{
  
  private List<SearchCodeResponseDto> searchCodeList;

  private GetSearchCodeListResponseDto(String code, String message, List<SearchCodeResponseDto> searchCodeList){
    super(code, message);
    this.searchCodeList = searchCodeList;
  }

  public static ResponseEntity<GetSearchCodeListResponseDto> success(List<SearchCodeResponseDto> searchCodeList){
    GetSearchCodeListResponseDto result = new GetSearchCodeListResponseDto(ResponseCode.Success, ResponseMessage.Success, searchCodeList);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }
}
