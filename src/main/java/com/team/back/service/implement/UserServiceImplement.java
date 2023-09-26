package com.team.back.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team.back.dto.request.auth.SignInRequestDto;
import com.team.back.dto.response.ResponseDto;
import com.team.back.dto.response.auth.SignInResponseDto;
import com.team.back.dto.response.user.GetSignInUserResponseDto;
import com.team.back.entity.UserEntity;
import com.team.back.entity.UserViewEntity;
import com.team.back.provider.JwtProvider;
import com.team.back.repository.UserRepository;
import com.team.back.repository.UserViewRepository;
import com.team.back.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService {
    private final UserRepository userRepository;
    private final UserViewRepository userviewRepository;
    private final JwtProvider jwtProvider;

    @Override
    //!       로그인 메서드            //
    public ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto) {
        String token = null;

        try{
            // 사원번호로 entity 조회 //
            UserEntity userEntity = userRepository.findByEmployeeCode(dto.getEmployeeCode());
            
            // 존재하는 사원번호인지 확인 //
            if(userEntity == null) return SignInResponseDto.signInDataMismatch();

            // 비밀번호 일치여부 확인 // //! todo : 사원등록 시 encoding 하면 수정할 것
            String password = userEntity.getPassword();
            boolean equalPassword = password.equals(dto.getPassword());
            if( !equalPassword ) return SignInResponseDto.signInDataMismatch();
            
            // JWT 생성 //
            token = jwtProvider.create(dto.getEmployeeCode());

        } catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return SignInResponseDto.success(token);
    }

    @Override
    //!       로그인유저 정보 가져오기 메서드         //
     public ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(Integer employeeCode) {
        UserViewEntity userViewEntity = null;

        try {
            // 사원번호로 entity 조회 //
            userViewEntity = userviewRepository.findByEmployeeCode(employeeCode);

            // 존재하는 사원번호인지 확인 //
            if (userViewEntity == null) return GetSignInUserResponseDto.noExistedUser();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

     return GetSignInUserResponseDto.success(userViewEntity);
     }
}
