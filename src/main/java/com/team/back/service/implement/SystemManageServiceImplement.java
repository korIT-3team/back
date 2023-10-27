package com.team.back.service.implement;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.team.back.common.constants.DepartmentCode;
import com.team.back.dto.request.system.PutCompanyInfoRequestDto;
import com.team.back.dto.request.system.PutCustomerInfoRequestDto;
import com.team.back.dto.request.system.PutDepartmentInfoRequestDto;
import com.team.back.dto.request.system.PutProductInfoRequestDto;
import com.team.back.dto.request.system.PutSystemEmployeeInfoRequestDto;
import com.team.back.dto.response.ResponseDto;
import com.team.back.dto.response.system.PutCompanyInfoResponseDto;
import com.team.back.dto.response.system.PutCustomerInfoResponseDto;
import com.team.back.dto.response.system.PutDepartmentInfoResponseDto;
import com.team.back.dto.response.system.PutProductInfoResponseDto;
import com.team.back.dto.response.system.PutSystemEmployeeInfoResponseDto;
import com.team.back.dto.response.system.Employee.GetSystemEmpUserDefineInfoResponseDto;
import com.team.back.dto.response.system.Employee.GetSystemEmployeeInfoResponseDto;
import com.team.back.dto.response.system.Employee.SystemEmpUserDefineListResponseDto;
import com.team.back.dto.response.system.Employee.SystemEmployeeListResponseDto;
import com.team.back.dto.response.system.CustomerListResponseDto;
import com.team.back.dto.response.system.DeleteCustomerInfoResponseDto;
import com.team.back.dto.response.system.DeleteDepartmentInfoResponseDto;
import com.team.back.dto.response.system.DeleteProductInfoResponseDto;
import com.team.back.dto.response.system.DeleteSystemEmployeeInfoResponseDto;
import com.team.back.dto.response.system.DepartmentListResponseDto;
import com.team.back.dto.response.system.GetCompanyInfoResponseDto;
import com.team.back.dto.response.system.GetCustomerInfoResponseDto;
import com.team.back.dto.response.system.GetDepartmentInfoResponseDto;
import com.team.back.dto.response.system.GetProductInfoResponseDto;
import com.team.back.dto.response.system.ProductListResponseDto;
import com.team.back.entity.CompanyEntity;
import com.team.back.entity.CustomerEntity;
import com.team.back.entity.DepartmentEntity;
import com.team.back.entity.ProductEntity;
import com.team.back.entity.SystemEmployeeEntity;
import com.team.back.entity.resultSets.CustomerListResultSet;
import com.team.back.entity.resultSets.DepartmentListResultSet;
import com.team.back.entity.resultSets.ProductListResultSet;
import com.team.back.entity.resultSets.UserDefineListResultSet;
import com.team.back.entity.resultSets.SystemEmployeeListResultSet;
import com.team.back.repository.CompanyRepository;
import com.team.back.repository.CustomerRepository;
import com.team.back.repository.DepartmentRepository;
import com.team.back.repository.ProductRepository;
import com.team.back.repository.UserDefineRepository;
import com.team.back.repository.SystemEmployeeRepository;
import com.team.back.repository.UserRepository;
import com.team.back.repository.UserViewRepository;
import com.team.back.service.SystemManageService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SystemManageServiceImplement implements SystemManageService{
     
     private final CompanyRepository companyRepository;
     private final UserRepository userRepository;
     private final UserViewRepository userViewRepository;
     private final DepartmentRepository departmentRepository;
     private final SystemEmployeeRepository systemEmployeeRepository;
     private final UserDefineRepository systemEmpUserDefineRepository;
     private final CustomerRepository customerRepository;
     private final ProductRepository productRepository;

     private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

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
     public ResponseEntity<? super PutCompanyInfoResponseDto> putCompanyInfo(String employeeCode, PutCompanyInfoRequestDto dto) {
          
          Integer emCode = Integer.parseInt(employeeCode);
          try{
               // description: 존재하는 사원번호인지 확인 //
               boolean hasUser = userRepository.existsByEmployeeCode(emCode);
               if(!hasUser) return PutCompanyInfoResponseDto.noExistedUser();
               // description: 권한 //
               Integer dpCode = userViewRepository.getUserDepartmentCode(emCode);
               if(!DepartmentCode.SYSTEM.equals(dpCode)) return PutCompanyInfoResponseDto.noPermission();

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
     public ResponseEntity<? super PutDepartmentInfoResponseDto> putDepartmentInfo(String employeeCode, PutDepartmentInfoRequestDto dto) {
          int departmentCode = dto.getDepartmentCodeInfo();
          String departmentName = dto.getDepartmentNameInfo();
          String departmentTelNumber = dto.getDepartmentTelNumber();
          String departmentFax = dto.getDepartmentFax();
          Integer emCode = Integer.parseInt(employeeCode);
          try{
               // description: 신규입력의 경우
               if (departmentCode == 0) {
                    // description: 부서명 중복 확인
                    boolean hasDeptName = departmentRepository.existsByDepartmentName(departmentName);
                    if (hasDeptName) return PutDepartmentInfoResponseDto.existedDeptname();
                    // description: 부서전화번호 중복 확인
                    boolean hasTelNumber = departmentRepository.existsByDepartmentTelNumber(departmentTelNumber);
                    if (hasTelNumber) return PutDepartmentInfoResponseDto.existedDeptTelNumber();
                    // description: 부서FAX 중복 확인
                    boolean hasFax = departmentRepository.existsByDepartmentFax(departmentFax);
                    if (hasFax) return PutDepartmentInfoResponseDto.existedDeptFax();
               } else {
                    // description: 부서전화번호 중복 확인
                    DepartmentEntity deptTelNumberEntity = departmentRepository.findByDepartmentTelNumber(departmentTelNumber);
                    if (deptTelNumberEntity != null) {
                         if (departmentCode != deptTelNumberEntity.getDepartmentCode()) return PutDepartmentInfoResponseDto.existedDeptTelNumber();
                    }

                    // description: 부서FAX 중복 확인
                    DepartmentEntity deptFaxEntity = departmentRepository.findByDepartmentFax(departmentFax);
                    if (deptFaxEntity != null) {
                         if (departmentCode != deptFaxEntity.getDepartmentCode()) return PutDepartmentInfoResponseDto.existedDeptFax();                    
                    }
               }

               // description: 존재하는 사원번호인지 확인 //
               boolean hasUser = userRepository.existsByEmployeeCode(emCode);
               if(!hasUser) return PutDepartmentInfoResponseDto.noExistedUser();

               // description:  권한 //
               Integer dpCode = userViewRepository.getUserDepartmentCode(emCode);
               if(!DepartmentCode.SYSTEM.equals(dpCode)) return PutDepartmentInfoResponseDto.noPermission();

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
     public ResponseEntity<? super DeleteDepartmentInfoResponseDto> deleteDepartmentInfo(String employeeCode, Integer departmentCode) {
          Integer emCode = Integer.parseInt(employeeCode);
          try {
               // description: 존재하는 유저인지 확인 //
               boolean hasUser = userRepository.existsByEmployeeCode(emCode);
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
     public ResponseEntity<? super GetDepartmentInfoResponseDto> getDepartmentInfo(String employeeCode, String departmentName) {
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
     public ResponseEntity<? super PutSystemEmployeeInfoResponseDto> putSystemEmployeeInfo(String employeeCode, PutSystemEmployeeInfoRequestDto dto) {
          int systemEmployeeCode = dto.getSysEmployeeCode();
          String systemEmployeeName = dto.getEmployeeName();
          String systemEmployeeRegistrationNumber = dto.getRegistrationNumber();
          String password = dto.getPassword();
          Integer emCode = Integer.parseInt(employeeCode);

          try{
               // description: 신규입력의 경우
               if (systemEmployeeCode == 0) {
                    // description: 사원명 중복 확인
                    boolean hasEmployeeName = systemEmployeeRepository.existsByEmployeeName(systemEmployeeName);
                    if (hasEmployeeName) return PutSystemEmployeeInfoResponseDto.existedSystemEmployeeName();
                    // description: 부서전화번호 중복 확인
                    boolean hasregistrationNumber = systemEmployeeRepository.existsByRegistrationNumber(systemEmployeeRegistrationNumber);
                    if (hasregistrationNumber) return PutSystemEmployeeInfoResponseDto.existedSystemEmployeeRegistrationNumber();
                    // description: 비밀번호 암호화  ( 초기화 : "0000" //
                    password = passwordEncoder.encode("0000");

               } else {
                    // description: 부서전화번호 중복 확인
                    SystemEmployeeEntity registrationNumberEntity = systemEmployeeRepository.findByRegistrationNumber(systemEmployeeRegistrationNumber);
                    if (registrationNumberEntity != null) {
                         if (systemEmployeeCode != registrationNumberEntity.getEmployeeCode()) return PutSystemEmployeeInfoResponseDto.existedSystemEmployeeRegistrationNumber();
                    }
                    // description: 기존 저장된 암호 불러오기
                    SystemEmployeeEntity employeeEntity = systemEmployeeRepository.findByEmployeeCode(systemEmployeeCode);
                    password = employeeEntity.getPassword();
               }

               // description: 존재하는 사원번호인지 확인 //
               boolean hasUser = userRepository.existsByEmployeeCode(emCode);
               if(!hasUser) return PutDepartmentInfoResponseDto.noExistedUser();

               // description:  권한 //
               Integer dpCode = userViewRepository.getUserDepartmentCode(emCode);
               if(!DepartmentCode.SYSTEM.equals(dpCode)) return PutDepartmentInfoResponseDto.noPermission();

               // description: dto의 password 변경 //
               dto.setPassword(password);

               // description:  Entity 생성 //
               SystemEmployeeEntity systemEmployeeEntity = new SystemEmployeeEntity(dto);
               
               // description:  DB에 저장 //
               systemEmployeeRepository.save(systemEmployeeEntity);

          } catch(Exception exception){
               // description: 데이터베이스 에러 //
               exception.printStackTrace();
               return ResponseDto.databaseError();
          }

        return PutSystemEmployeeInfoResponseDto.success();
     }

     @Override
     public ResponseEntity<? super DeleteSystemEmployeeInfoResponseDto> deleteSystemEmployeeInfo(String employeeCode, Integer deleteSystemEmployeeCode) {
          Integer emCode = Integer.parseInt(employeeCode);
          try {
               // description: 존재하는 유저인지 확인 //
               boolean hasUser = userRepository.existsByEmployeeCode(emCode);
               if (!hasUser) return DeleteSystemEmployeeInfoResponseDto.noExistedUser();
               // description: 존재하는 사원코드인지 확인 //
               SystemEmployeeEntity systemEmployeeEntity = systemEmployeeRepository.findByEmployeeCode(deleteSystemEmployeeCode);
               if (systemEmployeeEntity == null) return DeleteSystemEmployeeInfoResponseDto.noExistedSystemEmployee();
               // description: 사원 삭제 //
               systemEmployeeRepository.delete(systemEmployeeEntity);
          } catch (Exception exception) {
               exception.printStackTrace();
               return ResponseDto.databaseError();
          }
          return DeleteSystemEmployeeInfoResponseDto.success();
     }     

     @Override
     public ResponseEntity<? super GetSystemEmployeeInfoResponseDto> getSystemEmployeeInfo(String employeeCode, String systemEmployeeName) {
          List<SystemEmployeeListResponseDto> systemEmployeeList = null;

          try {
               systemEmployeeName = systemEmployeeName == null ? "": systemEmployeeName;
               // description: 검색어가 사원명에 포함되어 있는 데이터 조회 //
               List<SystemEmployeeListResultSet> systemEmployeeEntities = systemEmployeeRepository.getSystemEmployeeList(systemEmployeeName);

               // // description: 비밀번호 암호화 //
               // password = passwordEncoder.encode(password);
               // // description: dto의 password 변경 //
               // dto.setPassword(password);
               
               // description: entity를 dto형태로 변환 //
               systemEmployeeList = SystemEmployeeListResponseDto.copyList(systemEmployeeEntities);

             } catch(Exception exception) {
               exception.printStackTrace();
               return ResponseDto.databaseError();
             }
             return GetSystemEmployeeInfoResponseDto.success(systemEmployeeList);
     }

     @Override
     public ResponseEntity<? super GetSystemEmpUserDefineInfoResponseDto> getSystemEmpUserDefineInfo(String employeeCode, Integer userDefineCode) {
          List<SystemEmpUserDefineListResponseDto> systemEmpUserDefineList = null;
          try {
               // description: 사용자정의코드를 가진 user_define_detail 데이터 조회
               List<UserDefineListResultSet> userDefineEntities = systemEmpUserDefineRepository.getUserDefineList(userDefineCode);
               // description: entity를 dto형태로 변환 //
               systemEmpUserDefineList = SystemEmpUserDefineListResponseDto.copyList(userDefineEntities);
               
          } catch(Exception exception) {
               exception.printStackTrace();
               return ResponseDto.databaseError();
          }
          return GetSystemEmpUserDefineInfoResponseDto.success(systemEmpUserDefineList);
     }
     
     @Override
     public ResponseEntity<? super PutCustomerInfoResponseDto> putCustomerInfo(String employeeCode, PutCustomerInfoRequestDto dto) {
          Integer emCode = Integer.parseInt(employeeCode);
          int customerCode = dto.getCustomerCodeInfo();
          String customerName = dto.getCustomerNameInfo();
          String customerBusinessNumber = dto.getCustomerBusinessNumber();

          try {
               // description: 신규입력의 경우 //
               if (customerCode == 0) {

                    // description: 거래처 명 중복 확인 //
                    boolean hasCustomerName = customerRepository.existsByCustomerName(customerName);
                    if (hasCustomerName) return PutCustomerInfoResponseDto.existedCustomerName();

                    // description: 사업자 등록번호 중복 확인 //
                    boolean hasCustomerBusinessNumber = customerRepository.existsByCustomerBusinessNumber(customerBusinessNumber);
                    if (hasCustomerBusinessNumber) return PutCustomerInfoResponseDto.existedCustomerBusinessNumber();
               
               } else {
                    // description: 사업자 등록번호 중복 확인 //
                    CustomerEntity custBusinessNumberEntity = customerRepository.findByCustomerBusinessNumber(customerBusinessNumber);
                    if (custBusinessNumberEntity != null) {
                         if (customerCode != custBusinessNumberEntity.getCustomerCode()) return PutCustomerInfoResponseDto.existedCustomerBusinessNumber();
                    }
               }
            
               // description: 존재하는 사원번호인지 확인 //
               boolean hasUser = userRepository.existsByEmployeeCode(emCode);
               if(!hasUser) return PutCustomerInfoResponseDto.noExistedUser();

               // description:  권한 //
               Integer dpCode = userViewRepository.getUserDepartmentCode(emCode);
               if(!DepartmentCode.SYSTEM.equals(dpCode)) return PutCustomerInfoResponseDto.noPermission();

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
     public ResponseEntity<? super DeleteCustomerInfoResponseDto> deleteCustomerInfo(String employeeCode, Integer customerCode) {
          Integer emCode = Integer.parseInt(employeeCode);
          try {
               // description: 존재하는 유저인지 확인 //
               boolean hasUser = userRepository.existsByEmployeeCode(emCode);
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
     public ResponseEntity<? super GetCustomerInfoResponseDto> getCustomerInfo(String employeeCode, String customerName) {
          List<CustomerListResponseDto> customerList = null;

          try{
               customerName = customerName == null ? "" : customerName;
               // description: 검색어가 거래처명에 포함되어 있는 데이터 조회 //
               List<CustomerListResultSet> customerEntities = customerRepository.getCustomerList(customerName);

               // description: entity를 dto형태로 변환 //
               customerList = CustomerListResponseDto.copyList(customerEntities);

          } catch(Exception exception){
               exception.printStackTrace();
               return ResponseDto.databaseError();
          }

          return GetCustomerInfoResponseDto.success(customerList);
     }

     @Override
     public ResponseEntity<? super PutProductInfoResponseDto> putProductInfo(String employeeCode, PutProductInfoRequestDto dto) {

          int productCode = dto.getProductCodeInfo();
          String productName = dto.getProductName();
          Integer emCode = Integer.parseInt(employeeCode);

          try {
               // description: 신규입력의 경우 //
               if (productCode == 0) {
                    // description: 품명 중복 확인 //
                    boolean hasProductName = productRepository.existsByProductName(productName);
                    if (hasProductName) return PutProductInfoResponseDto.existedProductName();
               }

               // description: 존재하는 사원번호인지 확인 //
               boolean hasUser = userRepository.existsByEmployeeCode(emCode);
               if(!hasUser) return PutProductInfoResponseDto.noExistedUser();

               // description:  권한 //
               Integer dpCode = userViewRepository.getUserDepartmentCode(emCode);
               if(!DepartmentCode.SYSTEM.equals(dpCode)) return PutProductInfoResponseDto.noPermission();;

               // description:  Entity 생성 //
               ProductEntity productEntity = new ProductEntity(dto);

               // description:  DB에 저장 //
               productRepository.save(productEntity);

          } catch(Exception exception){
               // description: 데이터베이스 에러 //
               exception.printStackTrace();
               return ResponseDto.databaseError();
          }

          return PutProductInfoResponseDto.success();

     }

     @Override
     public ResponseEntity<? super DeleteProductInfoResponseDto> deleteProductInfo(String employeeCode, Integer productCode) {
          Integer emCode = Integer.parseInt(employeeCode);
          try {
               // description: 존재하는 유저인지 확인 //
               boolean hasUser = userRepository.existsByEmployeeCode(emCode);
               if (!hasUser) return DeleteProductInfoResponseDto.noExistedUser();
               
               // description: 존재하는 품목코드인지 확인 //
               ProductEntity productEntity = productRepository.findByProductCode(productCode);
               if (productEntity == null) return DeleteProductInfoResponseDto.noExistedProduct();
               
               // description: 품목 삭제 //
               productRepository.delete(productEntity);

          } catch (Exception exception) {
               exception.printStackTrace();
               return ResponseDto.databaseError();
          }
          return DeleteProductInfoResponseDto.success();
     }


     @Override
     public ResponseEntity<? super GetProductInfoResponseDto> getProductInfo(String employeeCode, String productName) {
          
          List<ProductListResponseDto> productList = null;

          try{
               productName = productName == null ? "" : productName;
               // description: 검색어가 품명에 포함되어 있는 데이터 조회 //
               List<ProductListResultSet> productEntities = productRepository.getProductList(productName);

               // description: entity를 dto형태로 변환 //
               productList = ProductListResponseDto.copyList(productEntities);
          } catch(Exception exception){
               exception.printStackTrace();
               return ResponseDto.databaseError();
          }

          return GetProductInfoResponseDto.success(productList);   

     }
}
