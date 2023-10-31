package com.team.back.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team.back.dto.request.auth.KakaoSignInRequestDto;
import com.team.back.dto.request.auth.SignInRequestDto;
import com.team.back.dto.response.ResponseDto;
import com.team.back.dto.response.auth.KakaoSignInResponseDto;
import com.team.back.dto.response.auth.SignInResponseDto;
import com.team.back.dto.response.user.GetSignInUserResponseDto;
import com.team.back.entity.SystemEmployeeEntity;
import com.team.back.entity.UserViewEntity;
import com.team.back.entity.Oauth.OAuth2UserEntity;
import com.team.back.provider.JwtProvider;
import com.team.back.repository.OAuth2Repository;
import com.team.back.repository.SystemEmployeeRepository;
import com.team.back.repository.UserViewRepository;
import com.team.back.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService {
    private final UserViewRepository userviewRepository;
    private final JwtProvider jwtProvider;
    private final SystemEmployeeRepository systemEmployeeRepository;
    private final OAuth2Repository oAuth2Repository;

    @Override
    //!       로그인 메서드            //
    public ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto) {
        String token = null;

        try{
            // 사원번호로 entity 조회 //
            SystemEmployeeEntity userEntity = systemEmployeeRepository.findByEmployeeCode(dto.getEmployeeCode());
            
            // 존재하는 사원번호인지 확인 //
            if(userEntity == null) return SignInResponseDto.signInDataMismatch();

            // 비밀번호 일치여부 확인 // //! todo : 사원등록 시 encoding 하면 수정할 것
            String password = userEntity.getPassword();
            boolean equalPassword = password.equals(dto.getPassword());
            if( !equalPassword ) return SignInResponseDto.signInDataMismatch();
            
            // JWT 생성 //
            token = jwtProvider.create(dto.getEmployeeCode().toString());

        } catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return SignInResponseDto.success(token);
    }

    @Override
    //!       로그인유저 정보 가져오기 메서드         //
     public ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String employeeCode) {
        UserViewEntity userViewEntity = null;

        try {
            // 사원번호로 entity 조회 //
            Integer emCode = Integer.parseInt(employeeCode);
            userViewEntity = userviewRepository.findByEmployeeCode(emCode);

            // 존재하는 사원번호인지 확인 //
            if (userViewEntity == null) return GetSignInUserResponseDto.noExistedUser();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetSignInUserResponseDto.success(userViewEntity);
     }

    @Override
    public ResponseEntity<? super KakaoSignInResponseDto> KakaoSignIn(String id, KakaoSignInRequestDto requestBody) {
        OAuth2UserEntity oAuth2UserEntity = null;
        try {
            boolean existsById = oAuth2Repository.existsById(id);
            
            oAuth2UserEntity = new OAuth2UserEntity(id, requestBody.getEmployeeCode());
            
            // description : id가 존재하지않는다면 save
            if(!existsById) oAuth2Repository.save(oAuth2UserEntity);
            //! 존재하는 계정 : 사원번호와 매칭 확인
            //! 다른 사원번호 로그인 시 연동된 카카오-ERP 계정이 아닙니다. 알람
            else if(existsById){
                // description : 존재하는 id라면 매칭되는 사원번호를 가져와서 로그인하는 사람의 employeeCode와 매칭되는지 확인
                OAuth2UserEntity oAuth2UserEntity2 = oAuth2Repository.findById(id);
                if(oAuth2UserEntity2.getEmployeeCode().equals(requestBody.getEmployeeCode()) == false) return KakaoSignInResponseDto.NotMatchedId();
            }

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return KakaoSignInResponseDto.success();
    }
}
