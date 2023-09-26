package com.team.back.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team.back.dto.request.SignInRequestDto;
import com.team.back.dto.response.ResponseDto;
import com.team.back.dto.response.SignInResponseDto;
import com.team.back.repository.MainRepository;
import com.team.back.service.MainService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MainServiceImplement implements MainService {
     private final MainRepository mainRepository;

     @Override
    //!       로그인 메서드            //
    public ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto) {
        int employeeCode;
        try{
            employeeCode =dto.getEmployeeCode();
            // 이메일로 entity 조회 //
            boolean hasSucess = mainRepository.existsByEmployeeCode(employeeCode);
            
            System.out.println(hasSucess);

        } catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return SignInResponseDto.success(employeeCode);
    }
}
