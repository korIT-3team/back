package com.team.back.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team.back.dto.request.system.PutCompanyInfoRequestDto;
import com.team.back.dto.response.ResponseDto;
import com.team.back.dto.response.system.PutCompanyInfoResponseDto;
import com.team.back.dto.response.system.GetCompanyInfoResponseDto;
import com.team.back.entity.CompanyEntity;
import com.team.back.repository.CompanyRepository;
import com.team.back.repository.UserRepository;
import com.team.back.service.SystemManageService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SystemManageServiceImplement implements SystemManageService{
     
     private final CompanyRepository companyRepository;
     private final UserRepository userRepository;

     @Override
     public ResponseEntity<? super GetCompanyInfoResponseDto> getCompanyInfo() {
          
          CompanyEntity companyEntity;

          try{
               // 데이터베이스에서 회사정보 불러오기 //
               companyEntity = companyRepository.findByCompanyCode(1); 
          } catch(Exception exception){
               exception.printStackTrace();
               return ResponseDto.databaseError();
          }

          return GetCompanyInfoResponseDto.success(companyEntity);
     }

     @Override
     public ResponseEntity<? super PutCompanyInfoResponseDto> putCompanyInfo(Integer employeeCode, PutCompanyInfoRequestDto dto) {

        try{
            // 존재하는 사원번호인지 확인 //
            boolean hasUser = userRepository.existsByEmployeeCode(employeeCode);
            if(!hasUser) return PutCompanyInfoResponseDto.noExistedUser();
            // 권한 //
            if(employeeCode != 9999) return PutCompanyInfoResponseDto.noPermission();

            // entity 생성 //
            CompanyEntity companyEntity = new CompanyEntity(dto);
            
            // 데이터베이스에 저장 //
            companyRepository.save(companyEntity);
        } catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PutCompanyInfoResponseDto.success();
     }
}
