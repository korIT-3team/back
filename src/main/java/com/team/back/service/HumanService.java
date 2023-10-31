package com.team.back.service;

import org.springframework.http.ResponseEntity;

import com.team.back.dto.request.human.GetHumanDetailRequestDto;
import com.team.back.dto.request.human.PutHumanDetailInfoRequestDto;
import com.team.back.dto.request.human.PutIncentiveInfoRequestDto;
import com.team.back.dto.response.human.DeleteIncentiveInfoResponseDto;
import com.team.back.dto.response.human.GetEmploymentTypeListResponseDto;
import com.team.back.dto.response.human.GetHumanDetailInfoResponseDto;
import com.team.back.dto.response.human.GetHumanListResponseDto;
import com.team.back.dto.response.human.GetIncentiveListResponseDto;
import com.team.back.dto.response.human.PutHumanDetailInfoResponseDto;
import com.team.back.dto.response.human.PutIncentiveInfoResponseDto;

public interface HumanService {
     // API : 사원 리스트 불러오기 메서드 //
     ResponseEntity<? super GetHumanListResponseDto> getHumanList(String employeeCode, Integer departmentCode, Integer humanEmployeeCode, Integer employmentType);

     // API : 사원 - 재직구분 콤보박스 불러오기 메서드 //
     ResponseEntity<? super GetEmploymentTypeListResponseDto> getEmploymentType();

     // API : 인사정보등록 - (사원)인적정보 불러오기 메서드 //
     ResponseEntity<? super GetHumanDetailInfoResponseDto> getHumanDetailInfo(GetHumanDetailRequestDto requestBody);

     // API : 인사정보등록 - (사원)인적정보 저장 메서드 //
     ResponseEntity<? super PutHumanDetailInfoResponseDto> putHumanDetailInfo(String employeeCode, PutHumanDetailInfoRequestDto requestBody);

     // API : 급/상여정보등록 - 급/상여 리스트 불러오기 메서드 //
     ResponseEntity<? super GetIncentiveListResponseDto> getIncentiveList(String employeeCode, String incentiveEmployeeCode, String incentiveCategory);

     // API : 급/상여정보등록 - 사원 코드도움 불러오기 메서드 //
     ResponseEntity<? super GetHumanListResponseDto> getIncentiveEmployeeList();

     // API : 급/상여정보 등록 메서드 //
     ResponseEntity<? super PutIncentiveInfoResponseDto> putIncentiveInfo(String employeeCode, PutIncentiveInfoRequestDto dto);

     // API : 급/상여정보 삭제 메서드 //
     ResponseEntity<? super DeleteIncentiveInfoResponseDto> deleteIncentiveInfo(String employeeCode, Integer deleteIncentiveCode);     
}
