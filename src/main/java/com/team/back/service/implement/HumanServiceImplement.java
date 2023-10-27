package com.team.back.service.implement;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team.back.common.constants.DepartmentCode;
import com.team.back.dto.request.human.GetHumanDetailRequestDto;
import com.team.back.dto.request.human.PutHumanDetailInfoRequestDto;
import com.team.back.dto.response.ResponseDto;
import com.team.back.dto.response.human.EmploymentTypeResponseDto;
import com.team.back.dto.response.human.GetEmploymentTypeListResponseDto;
import com.team.back.dto.response.human.GetHumanDetailInfoResponseDto;
import com.team.back.dto.response.human.GetHumanListResponseDto;
import com.team.back.dto.response.human.GetIncentiveListResponseDto;
import com.team.back.dto.response.human.HumanListResponseDto;
import com.team.back.dto.response.human.IncentiveListResponseDto;
import com.team.back.dto.response.human.PutHumanDetailInfoResponseDto;
import com.team.back.dto.response.sales.PutSalesPlanInfoResponseDto;
import com.team.back.dto.response.system.PutDepartmentInfoResponseDto;
import com.team.back.entity.EmployeeViewEntity;
import com.team.back.entity.IncentiveEntity;
import com.team.back.entity.SystemEmployeeEntity;
import com.team.back.entity.UserDefineDetailEntity;
import com.team.back.entity.resultSets.IncentiveListResultSet;
import com.team.back.repository.EmployeeViewRepository;
import com.team.back.repository.HumanDetailRepository;
import com.team.back.repository.HumanViewReposiroty;
import com.team.back.repository.IncentiveRepository;
import com.team.back.repository.UserDefineDetailRepository;
import com.team.back.repository.UserRepository;
import com.team.back.repository.UserViewRepository;
import com.team.back.service.HumanService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HumanServiceImplement implements HumanService {

     private final UserRepository userRepository;
     private final UserViewRepository userViewRepository;
     private final UserDefineDetailRepository employmentTypeReposiroty;
     private final HumanDetailRepository humanDetailRepository;
     private final EmployeeViewRepository employeeViewRepository;
     private final HumanViewReposiroty humanViewReposiroty;
     private final IncentiveRepository incentiveRepository;


     @Override
     public ResponseEntity<? super PutHumanDetailInfoResponseDto> putHumanDetailInfo(Integer employeeCode, PutHumanDetailInfoRequestDto dto) {
        
      Integer humanEmployeeCode = dto.getHumanEmployeeCode();

      try{
          // description: 존재하는 사원번호인지 확인 //
          SystemEmployeeEntity humanEntity = userRepository.findByEmployeeCode(humanEmployeeCode);
          if (humanEntity == null) return PutHumanDetailInfoResponseDto.noExistedUser();
          // description: 권한 //
          Integer dpCode = userViewRepository.getUserDepartMentCode(employeeCode);
          if(!DepartmentCode.SYSTEM.equals(dpCode)) return PutHumanDetailInfoResponseDto.noPermission();
          // description: 수정 //
          humanEntity.patch(dto);
          // description: 데이터베이스에 저장 //
          humanDetailRepository.save(humanEntity);
          
      } catch(Exception exception){
          exception.printStackTrace();
          return ResponseDto.databaseError();
      }
      return PutHumanDetailInfoResponseDto.success();
    }


    @Override
    public ResponseEntity<? super GetHumanListResponseDto> getHumanList(Integer employeeCode, Integer departmentCode, Integer humanEmployeeCode, Integer employmentType) {
      List<HumanListResponseDto> humanList = null;

      // int -> string
      String humanEmploymentType = (employmentType == null) ? "0" : Integer.toString(employmentType);
      String humanDepartmentCode = (departmentCode == null) ? "0" : Integer.toString(departmentCode);
      String humanEmpCode = (humanEmployeeCode == null) ? "0" : Integer.toString(humanEmployeeCode);
      
      try {

        // description: 조회조건에 맞는 데이터 조회 //
        List<EmployeeViewEntity> humanEntities = humanViewReposiroty.getHumanViewList(humanDepartmentCode, humanEmpCode, humanEmploymentType);

        // description: entity를 dto형채로 변환 //
        humanList = HumanListResponseDto.copyList(humanEntities);

      } catch (Exception exception) {
        exception.printStackTrace();
        return ResponseDto.databaseError();
      }
      return GetHumanListResponseDto.success(humanList);
    
    };


    @Override
    public ResponseEntity<? super GetEmploymentTypeListResponseDto> getEmploymentType() {
      List<EmploymentTypeResponseDto> employmentTypeList = null;

      try {
            List<UserDefineDetailEntity> employmentTypeEntities = employmentTypeReposiroty.getEmploymentType();

            employmentTypeList = EmploymentTypeResponseDto.copyEntityList(employmentTypeEntities);

      } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
      }

      return GetEmploymentTypeListResponseDto.success(employmentTypeList);
    }


    @Override
    public ResponseEntity<? super GetHumanDetailInfoResponseDto> getHumanDetailInfo(GetHumanDetailRequestDto requestBody) {
      SystemEmployeeEntity humanDetailEntity;
      try {
            // description: 사원번호로 데이터 조회 //
            humanDetailEntity = humanDetailRepository.findByEmployeeCode(requestBody.getEmployeeCode());
            if (humanDetailEntity == null) return GetHumanDetailInfoResponseDto.noExistedEmployee();

      } catch (Exception exception) {
        exception.printStackTrace();
        return ResponseDto.databaseError();
      }
      
      return GetHumanDetailInfoResponseDto.success(humanDetailEntity);
    }


    @Override
    public ResponseEntity<? super GetIncentiveListResponseDto> getIncentiveList(String employeeCode ,String incentiveEmployeeCode, String incentiveCategory) {

      Integer emCode = Integer.parseInt(employeeCode);
      List<IncentiveListResponseDto> incentiveList = null;

      try {
        // description: 존재하는 사원번호인지 확인 //
        boolean hasUser = userRepository.existsByEmployeeCode(emCode);
        if(!hasUser) return PutDepartmentInfoResponseDto.noExistedUser();

        // description:  권한 //
        Integer dpCode = userViewRepository.getUserDepartMentCode(emCode);
        if(!DepartmentCode.SYSTEM.equals(dpCode)) return PutDepartmentInfoResponseDto.noPermission();

        // description: 조회조건에 맞는 데이터 조회 //
        List<IncentiveListResultSet> incentiveEntities = incentiveRepository.getIncentiveList(incentiveEmployeeCode, incentiveCategory);

        incentiveList = IncentiveListResponseDto.copyList(incentiveEntities);

      } catch (Exception exception) {
          exception.printStackTrace();
          return ResponseDto.databaseError();
      }
      return GetIncentiveListResponseDto.success(incentiveList);
    }  


    @Override
    public ResponseEntity<? super GetHumanListResponseDto> getIncentiveEmployeeList() {

      List<HumanListResponseDto> humanList = null;

      try {
        // description: 조회조건에 맞는 데이터 조회 //
        List<EmployeeViewEntity> humanEntities = humanViewReposiroty.getHumanViewList("0","0", "0");

        // description: entity를 dto형채로 변환 //
        humanList = HumanListResponseDto.copyList(humanEntities);

      } catch (Exception exception) {
        exception.printStackTrace();
        return ResponseDto.databaseError();
      }
      return GetHumanListResponseDto.success(humanList);
    }

}
