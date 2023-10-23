package com.team.back.dto.response.Human;

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
public class GetEmploymentTypeListResponseDto extends ResponseDto {
  private List<EmploymentTypeResponseDto> employmentTypeList;

  public GetEmploymentTypeListResponseDto(String code, String message, List<EmploymentTypeResponseDto> employmentTypeList){
          super(code, message);
          this.employmentTypeList = employmentTypeList;
  }
  
  public static ResponseEntity<GetEmploymentTypeListResponseDto> success(List<EmploymentTypeResponseDto> employmentTypeList) {
       GetEmploymentTypeListResponseDto result = new GetEmploymentTypeListResponseDto(ResponseCode.Success, ResponseMessage.Success, employmentTypeList);
       return ResponseEntity.status(HttpStatus.OK).body(result);
  }  
}
