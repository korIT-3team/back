package com.team.back.dto.response.system;

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
public class GetSearchDepartmentInfoResponseDto  extends ResponseDto {

  private List<DepartmentListResponseDto> departmentList;

  private GetSearchDepartmentInfoResponseDto(String code, String message, List<DepartmentListResponseDto> departmentList){
    super(code, message);
    this.departmentList = departmentList;
  } 

  public static ResponseEntity<GetSearchDepartmentInfoResponseDto> success(List<DepartmentListResponseDto> departmentList){
    GetSearchDepartmentInfoResponseDto result = new GetSearchDepartmentInfoResponseDto(ResponseCode.Success, ResponseMessage.Success, departmentList);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }
  
}
