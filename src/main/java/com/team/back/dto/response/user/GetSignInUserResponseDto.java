package com.team.back.dto.response.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.response.ResponseDto;
import com.team.back.entity.UserViewEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetSignInUserResponseDto extends ResponseDto{
     private Integer employeeCode;
     private String employeeName;
     private Integer departmentCode;
     private String departmentName;

     private GetSignInUserResponseDto(String code, String message, UserViewEntity userViewEntity){
        super(code, message);
        this.employeeCode = userViewEntity.getEmployeeCode();
        this.employeeName = userViewEntity.getEmployeeName();
        this.departmentCode= userViewEntity.getDepartmentCode();
        this.departmentName= userViewEntity.getDepartmentName();
    }

    public static ResponseEntity<GetSignInUserResponseDto> success(UserViewEntity userViewEntity){
        GetSignInUserResponseDto result = new GetSignInUserResponseDto(ResponseCode.Success, ResponseMessage.Success, userViewEntity);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    // 실패 - 존재하지않는 유저 //
    public static ResponseEntity<ResponseDto> noExistedUser(){
        ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_USER, ResponseMessage.NO_EXISTED_USER);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
    }

}