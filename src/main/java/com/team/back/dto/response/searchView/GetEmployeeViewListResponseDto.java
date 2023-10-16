package com.team.back.dto.response.searchView;
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
public class GetEmployeeViewListResponseDto extends ResponseDto {
     private List<EmployeeViewResponseDto> employeeViewList;

     private GetEmployeeViewListResponseDto(String code, String message, List<EmployeeViewResponseDto> employeeViewList){
          super(code, message);
          this.employeeViewList = employeeViewList;
     }

     public static ResponseEntity<GetEmployeeViewListResponseDto> success(List<EmployeeViewResponseDto> employeeViewList){
          GetEmployeeViewListResponseDto result = new GetEmployeeViewListResponseDto(ResponseCode.Success, ResponseMessage.Success, employeeViewList);
          return ResponseEntity.status(HttpStatus.OK).body(result);
     }
}
