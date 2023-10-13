package com.team.back.service.implement;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team.back.dto.request.system.PutCompanyInfoRequestDto;
import com.team.back.dto.request.system.PutCustomerInfoRequestDto;
import com.team.back.dto.request.system.PutDepartmentInfoRequestDto;
import com.team.back.dto.request.system.PutProductInfoRequestDto;
import com.team.back.dto.response.ResponseDto;
import com.team.back.dto.response.accounting.InvoiceResponseDto;
import com.team.back.dto.response.system.PutCompanyInfoResponseDto;
import com.team.back.dto.response.system.PutCustomerInfoResponseDto;
import com.team.back.dto.response.system.PutDepartmentInfoResponseDto;
import com.team.back.dto.response.system.PutProductInfoResponseDto;
import com.team.back.dto.response.system.CustomerListResponseDto;
import com.team.back.dto.response.system.DeleteCustomerInfoResponseDto;
import com.team.back.dto.response.system.DeleteDepartmentInfoResponseDto;
import com.team.back.dto.response.system.DepartmentListResponseDto;
import com.team.back.dto.response.system.GetCompanyInfoResponseDto;
import com.team.back.dto.response.system.GetCustomerInfoResponseDto;
import com.team.back.dto.response.system.GetDepartmentInfoResponseDto;
import com.team.back.dto.response.system.GetProductInfoResponseDto;
import com.team.back.entity.CompanyEntity;
import com.team.back.entity.CustomerEntity;
import com.team.back.entity.DepartmentEntity;
import com.team.back.entity.ProductEntity;
import com.team.back.entity.InvoiceEntity;
import com.team.back.entity.resultSets.CustomerListResultSet;
import com.team.back.entity.resultSets.DepartmentListResultSet;
import com.team.back.repository.CompanyRepository;
import com.team.back.repository.CustomerRepository;
import com.team.back.repository.DepartmentRepository;
import com.team.back.repository.ProductRepository;
import com.team.back.repository.UserRepository;
import com.team.back.service.SystemManageService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SystemManageServiceImplement implements SystemManageService{
     
     private final CompanyRepository companyRepository;
     private final UserRepository userRepository;
     private final DepartmentRepository departmentRepository;
     private final CustomerRepository customerRepository;
     private final ProductRepository productRepository;

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
            // description: 존재하는 사원번호인지 확인 //
            boolean hasUser = userRepository.existsByEmployeeCode(employeeCode);
            if(!hasUser) return PutCompanyInfoResponseDto.noExistedUser();
            // description: 권한 //
            if(employeeCode != 9999) return PutCompanyInfoResponseDto.noPermission();

            // description: entity 생성 //
            CompanyEntity companyEntity = new CompanyEntity(dto);
            
            // description: 데이터베이스에 저장 //
            companyRepository.save(companyEntity);
        } catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PutCompanyInfoResponseDto.success();
     }

     @Override
     public ResponseEntity<? super PutDepartmentInfoResponseDto> putDepartmentInfo(Integer employeeCode, PutDepartmentInfoRequestDto dto) {
          String departmentName = dto.getDepartmentNameInfo();
          
          try{
               // description: 부서명 중복 확인
               boolean hasDeptName = departmentRepository.existsByDepartmentName(departmentName);
               if (hasDeptName) return PutDepartmentInfoResponseDto.existedDeptname();

               // description: 존재하는 사원번호인지 확인 //
               boolean hasUser = userRepository.existsByEmployeeCode(employeeCode);
               if(!hasUser) return PutDepartmentInfoResponseDto.noExistedUser();

               // description:  권한 //
               if(employeeCode != 9999) return PutDepartmentInfoResponseDto.noPermission();

               // description:  Entity 생성 //
               DepartmentEntity departmentEntity = new DepartmentEntity(dto);
               
               // description:  DB에 저장 //
               
               departmentRepository.save(departmentEntity);

          } catch(Exception exception){
               // description: 데이터베이스 에러 //
               exception.printStackTrace();
               return ResponseDto.databaseError();
          }

        return PutDepartmentInfoResponseDto.success();
     }

     @Override
     public ResponseEntity<? super DeleteDepartmentInfoResponseDto> deleteDepartmentInfo(Integer employeeCode, Integer departmentCode) {
          System.out.println(departmentCode);
          try {
               // description: 존재하는 유저인지 확인 //
               boolean hasUser = userRepository.existsByEmployeeCode(employeeCode);
               if (!hasUser) return DeleteDepartmentInfoResponseDto.noExistedUser();
               // description: 존재하는 부서코드인지 확인 //
               DepartmentEntity departmentEntity = departmentRepository.findByDepartmentCode(departmentCode);
               if (departmentEntity == null) return DeleteDepartmentInfoResponseDto.noExistedDept();
               // description: 부서 삭제 //
               departmentRepository.delete(departmentEntity);
          } catch (Exception exception) {
               exception.printStackTrace();
               return ResponseDto.databaseError();
          }
          return DeleteDepartmentInfoResponseDto.success();
     }


     @Override
     public ResponseEntity<? super GetDepartmentInfoResponseDto> getDepartmentInfo(Integer employeeCode, String departmentName) {
          List<DepartmentListResponseDto> departmentList = null;
          try{

               departmentName = departmentName == null ? "" : departmentName;
               // description: 검색어가 부서명에 포함되어 있는 데이터 조회 //
               List<DepartmentListResultSet> departmentEntities = departmentRepository.getDepartmentList(departmentName);
         
               // description: entity를 dto형태로 변환 //
               departmentList = DepartmentListResponseDto.copyList(departmentEntities);
         
             } catch(Exception exception) {
               exception.printStackTrace();
               return ResponseDto.databaseError();
             }
             return GetDepartmentInfoResponseDto.success(departmentList);
     }

     @Override
     public ResponseEntity<? super GetCustomerInfoResponseDto> getCustomerInfo(Integer employeeCode, Integer customerCode, String customerName) {
          List<CustomerListResponseDto> customerList = null;

          try{
               
               customerCode = customerCode == null ? null : customerCode;
               customerName = customerName == null ? "" : customerName;
               // description: 검색어가 거레처 코드 및 거래처명에 포함되어 있는 데이터 조회 //
               List<CustomerListResultSet> customerEntities = customerRepository.getCustomerList(customerCode, customerName);

               // description: entity를 dto형태로 변환 //
               customerList = CustomerListResponseDto.copyList(customerEntities);

          } catch(Exception exception){
               exception.printStackTrace();
               return ResponseDto.databaseError();
          }

          return GetCustomerInfoResponseDto.success(customerList);
     }

     @Override
     public ResponseEntity<? super PutCustomerInfoResponseDto> putCustomerInfo(Integer employeeCode, PutCustomerInfoRequestDto dto) {

          String customerName = dto.getCustomerNameInfo();
          int customerCode = dto.getCustomerCodeInfo();

          try {

               // description: 거래처 코드 중복 확인
               CustomerEntity custEntity = customerRepository.findByCustomerCode(customerCode);
               int getCustEntityCode = custEntity.getCustomerCode();
               boolean sameCustInfo = (getCustEntityCode == customerCode);
               boolean hasCustCode = customerRepository.existsByCustomerCode(customerCode);
               if (!sameCustInfo && hasCustCode) return PutCustomerInfoResponseDto.existedCustomerCode();

               // description: 거래처 명 중복 확인
               boolean hasCustomerName = customerRepository.existsByCustomerName(customerName);
               if (hasCustomerName) return PutCustomerInfoResponseDto.existedCustomerName();

               // description: 사업자 등록번호 중복 확인
               boolean hasCustomerBusinessNumber = customerRepository.existsByCustomerName(customerName);
               if (hasCustomerBusinessNumber) return PutCustomerInfoResponseDto.existedCustomerName();
            
               // description: 존재하는 사원번호인지 확인 //
               boolean hasUser = userRepository.existsByEmployeeCode(employeeCode);
               if(!hasUser) return PutCustomerInfoResponseDto.noExistedUser();

               // description:  권한 //
               if(employeeCode != 9999) return PutCustomerInfoResponseDto.noPermission();

               // description:  Entity 생성 //
               CustomerEntity customerEntity = new CustomerEntity(dto);

               // description:  DB에 저장 //
               customerRepository.save(customerEntity);

          } catch(Exception exception){
               // description: 데이터베이스 에러 //
               exception.printStackTrace();
               return ResponseDto.databaseError();
          }

        return PutCustomerInfoResponseDto.success();

     }

     @Override
     public ResponseEntity<? super DeleteCustomerInfoResponseDto> deleteCustomerInfo(Integer employeeCode, Integer customerCode) {
          try {
               // description: 존재하는 유저인지 확인 //
               boolean hasUser = userRepository.existsByEmployeeCode(employeeCode);
               if (!hasUser) return DeleteCustomerInfoResponseDto.noExistedUser();
               // description: 존재하는 거래처코드인지 확인 //
               CustomerEntity customerEntity = customerRepository.findByCustomerCode(customerCode);
               if (customerEntity == null) return DeleteCustomerInfoResponseDto.noExistedCustomerCode();
               // description: 거래처 삭제 //
               customerRepository.delete(customerEntity);
          } catch (Exception exception) {
               exception.printStackTrace();
               return ResponseDto.databaseError();
          }
          return DeleteCustomerInfoResponseDto.success();
     } 

     @Override
     public ResponseEntity<? super GetProductInfoResponseDto> getProductInfo() {

          ProductEntity productEntity;

          try{
               // 데이터베이스에서 품목 정보 불러오기 //
               productEntity = productRepository.findByProductCode(2000);
          } catch(Exception exception){
               exception.printStackTrace();
               return ResponseDto.databaseError();
          }

          return GetProductInfoResponseDto.success(productEntity);   

     }

     @Override
     public ResponseEntity<? super PutProductInfoResponseDto> putProductInfo(Integer employeeCode, PutProductInfoRequestDto dto) {

          try{
            // 존재하는 사원번호인지 확인 //
            boolean hasUser = userRepository.existsByEmployeeCode(employeeCode);
            if(!hasUser) return PutCompanyInfoResponseDto.noExistedUser();
            // 권한 //
            if(employeeCode != 9999) return PutCompanyInfoResponseDto.noPermission();

            // entity 생성 //
            ProductEntity productEntity = new ProductEntity(dto);
            
            // 데이터베이스에 저장 //
            productRepository.save(productEntity);
        } catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return PutProductInfoResponseDto.success();


     }
     
}
