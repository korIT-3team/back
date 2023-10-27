package com.team.back.service;

import org.springframework.http.ResponseEntity;

import com.team.back.dto.request.human.GetHumanDetailRequestDto;
import com.team.back.dto.request.human.PutHumanDetailInfoRequestDto;
import com.team.back.dto.response.human.GetEmploymentTypeListResponseDto;
import com.team.back.dto.response.human.GetHumanDetailInfoResponseDto;
import com.team.back.dto.response.human.GetHumanListResponseDto;
import com.team.back.dto.response.human.PutHumanDetailInfoResponseDto;

public interface HumanService {
     // API : 사원 리스트 불러오기 메서드 //
     ResponseEntity<? super GetHumanListResponseDto> getHumanList(String employeeCode, Integer departmentCode, Integer humanEmployeeCode, Integer employmentType);

     // API : 사원 - 재직구분 콤보박스 불러오기 메서드 //
     ResponseEntity<? super GetEmploymentTypeListResponseDto> getEmploymentType();

     // API : 인사정보등록 - (사원)인적정보 불러오기 메서드 //
     ResponseEntity<? super GetHumanDetailInfoResponseDto> getHumanDetailInfo(GetHumanDetailRequestDto requestBody);

     // API : 인사정보등록 - (사원)인적정보 저장 메서드 //
     ResponseEntity<? super PutHumanDetailInfoResponseDto> putHumanDetailInfo(String employeeCode, PutHumanDetailInfoRequestDto requestBody);
  
}
