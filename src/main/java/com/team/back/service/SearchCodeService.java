package com.team.back.service;

import org.springframework.http.ResponseEntity;

import com.team.back.dto.request.common.GetCustomerDetailCodeRequestDto;
import com.team.back.dto.request.common.GetDepartmentDetailCodeRequestDto;
import com.team.back.dto.request.common.GetEmployeeDetailCodeRequestDto;
import com.team.back.dto.request.common.GetProjectDetailCodeRequestDto;
import com.team.back.dto.response.common.GetSearchCodeListResponseDto;

public interface SearchCodeService {
     ResponseEntity<? super GetSearchCodeListResponseDto> getEmployeeList(GetEmployeeDetailCodeRequestDto requestBody);
     ResponseEntity<? super GetSearchCodeListResponseDto> getDepartmentList(GetDepartmentDetailCodeRequestDto requestBody);
     ResponseEntity<? super GetSearchCodeListResponseDto> getCustomerList(GetCustomerDetailCodeRequestDto requestBody);
     ResponseEntity<? super GetSearchCodeListResponseDto> getProjecttList(GetProjectDetailCodeRequestDto requestBody);
}
