package com.team.back.dto.response.system;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.response.ResponseDto;
import com.team.back.entity.CompanyEntity;
import com.team.back.entity.DepartmentEntity;

import lombok.Getter;

@Getter
public class GetDepartmentInfoResponseDto extends ResponseDto{
    private List<DepartmentListResponseDto> departmentList;
  // private String no;
  // private int companyCode;
  // private int departmentCode;
  // private String departmentName;
  // private String departmentStartDate;
  // private String departmentEndDate;
  // private String departmetTelnumber;
  // private String departmentFax;

  private GetDepartmentInfoResponseDto(String code, String message, List<DepartmentListResponseDto> departmentList){
    super(code, message);
    this.departmentList = departmentList;
    // this.departmentCode = departmentEntity.getDepartmentCode();
    // this.companyCode = departmentEntity.getCompanyCode();
    // this.departmentName = departmentEntity.getDepartmentName();
    // this.departmentStartDate = departmentEntity.getDepartmentStartDate();
    // this.departmentEndDate = departmentEntity.getDepartmentEndDate();
    // this.departmetTelnumber = departmentEntity.getDepartmetTelnumber();
    // this.departmentFax = departmentEntity.getDepartmentFax();
  }

  public static ResponseEntity<GetDepartmentInfoResponseDto> success(List<DepartmentListResponseDto> departmentList){
    GetDepartmentInfoResponseDto result = new GetDepartmentInfoResponseDto(ResponseCode.Success, ResponseMessage.Success, departmentList);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  // public static ResponseEntity<GetDepartmentInfoResponseDto> success(DepartmentEntity departmentEntity) {
  //   GetDepartmentInfoResponseDto result = new GetDepartmentInfoResponseDto(ResponseCode.Success, ResponseMessage.Success, departmentEntity);
  //   return ResponseEntity.status(HttpStatus.OK).body(result);
  // }

  public static ResponseEntity<ResponseDto> noExistedDepartmentInfo() {
    ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_DEPARTMENT_INFO, ResponseMessage.NO_EXISTED_DEPARTMENT_INFO);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }
  
}
