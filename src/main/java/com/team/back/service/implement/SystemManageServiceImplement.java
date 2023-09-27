package com.team.back.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team.back.dto.request.system.PutCompanyInfoRequestDto;
import com.team.back.dto.response.system.PutCompanyInfoResponseDto;
import com.team.back.repository.CompanyInfoRepository;
import com.team.back.service.SystemManageService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SystemManageServiceImplement implements SystemManageService{
     
     private final CompanyInfoRepository boardRepository;

     @Override
     public ResponseEntity<? super PutCompanyInfoResponseDto> putCompanyInfo(Integer employeeCode, PutCompanyInfoRequestDto dto) {
          // TODO Auto-generated method stub
          throw new UnsupportedOperationException("Unimplemented method 'putCompanyInfo'");
     }
}
