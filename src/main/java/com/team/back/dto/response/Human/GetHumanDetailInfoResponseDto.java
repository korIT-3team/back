package com.team.back.dto.response.Human;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.response.ResponseDto;
import com.team.back.entity.SystemEmployeeEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetHumanDetailInfoResponseDto extends ResponseDto {
  private String employeeImage;
  private String email;
  private String nationality;
  private String address;
  private String addressDetail;
  private String telNumber;
  private Integer education;
  private Integer militaryService;
  private String career;
  private Integer position;
  private Integer job;

  private GetHumanDetailInfoResponseDto(String code, String message, SystemEmployeeEntity employeeEntity) {
    super(code, message);
    this.employeeImage = employeeEntity.getEmployeeImage();
    this.email = employeeEntity.getEmail();
    this.nationality = employeeEntity.getNationality();
    this.address = employeeEntity.getAddress();
    this.addressDetail = employeeEntity.getAddressDetail();
    this.telNumber = employeeEntity.getTelNumber();
    this.education = employeeEntity.getEducation();
    this.militaryService = employeeEntity.getMilitaryService();
    this.career = employeeEntity.getCareer();
    this.position = employeeEntity.getPosition();
    this.job = employeeEntity.getJob();
  }

  public static ResponseEntity<GetHumanDetailInfoResponseDto> success(SystemEmployeeEntity employeeEntity) {
    GetHumanDetailInfoResponseDto result = new GetHumanDetailInfoResponseDto(ResponseCode.Success, ResponseMessage.Success, employeeEntity);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  public static ResponseEntity<ResponseDto> noExistedEmployee() {
      ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_SYSTEM_EMPLOYEE_INFO, ResponseMessage.NO_EXISTED_SYSTEM_EMPLOYEE_INFO);
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }
  
}
