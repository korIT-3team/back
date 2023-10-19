package com.team.back.service;

import org.springframework.http.ResponseEntity;

import com.team.back.dto.request.common.GetEmployeeDetailCodeRequestDto;
import com.team.back.dto.response.common.GetSearchCodeListResponseDto;

public interface SearchCodeService {
     ResponseEntity<? super GetSearchCodeListResponseDto> getEmployeeList(GetEmployeeDetailCodeRequestDto requestBody);
}
