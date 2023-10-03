package com.team.back.dto.response.system;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.team.back.common.response.ResponseCode;
import com.team.back.common.response.ResponseMessage;
import com.team.back.dto.response.ResponseDto;
import com.team.back.entity.CompanyEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetCompanyInfoResponseDto extends ResponseDto{
  private String logoImageUrl;
  private String bizNumber;
  private String companyName;
  private String repName;
  private String postCode;
  private String companyAddress;
  private String companyAddressDetail;
  private String telNumber;
  private String bizStatus;
  private String bizType;
  private String englishName;
  private String homepage;

  private GetCompanyInfoResponseDto(String code, String message, CompanyEntity companyEntity){
      super(code, message);
      this.logoImageUrl = companyEntity.getCompanyLogo();
      this.bizNumber = companyEntity.getBusinessNumber();
      this.companyName = companyEntity.getCompanyName();
      this.repName = companyEntity.getRepresentativeName();
      this.postCode = companyEntity.getCompanyPostCode();
      this.companyAddress = companyEntity.getCompanyAddress();
      this.companyAddressDetail = companyEntity.getCompanyAddressDetail();
      this.telNumber = companyEntity.getCompanyTelNumber();
      this.bizStatus = companyEntity.getBusinessStatus();
      this.bizType = companyEntity.getBusinessType();
      this.englishName = companyEntity.getEnglishCompanyName();
      this.homepage = companyEntity.getCompanyHomepage();
  }

  public static ResponseEntity<GetCompanyInfoResponseDto> success(CompanyEntity companyEntity) {
    GetCompanyInfoResponseDto result = new GetCompanyInfoResponseDto(ResponseCode.Success, ResponseMessage.Success, companyEntity);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }
  
  public static ResponseEntity<ResponseDto> noExistedComapanyInfo() {
      ResponseDto result = new ResponseDto(ResponseCode.NO_EXISTED_COMPANY_INFO, ResponseMessage.NO_EXISTED_COMPANY_INFO);
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }
}
