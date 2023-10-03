package com.team.back.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.team.back.dto.request.system.PutCompanyInfoRequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="company")
@Table(name="company")
public class CompanyEntity {
     @Id
     private int companyCode;
     private String companyName;
     private String businessNumber;
     private String representativeName;
     private String companyAddress;
     private String companyAddressDetail;
     private String companyTelNumber;
     private String businessStatus;
     private String businessType;
     private String englishCompanyName;
     private String companyHomepage;
     private String companyLogo;
     private String companyPostCode;

     public CompanyEntity(PutCompanyInfoRequestDto dto){
          this.companyCode = 1;
          this.companyName = dto.getCompanyName();
          this.businessNumber = dto.getBizNumber();
          this.representativeName = dto.getRepName();
          this.companyAddress = dto.getCompanyAddress();
          this.companyAddressDetail = dto.getCompanyAddressDetail();
          this.companyTelNumber = dto.getTelNumber();
          this.businessStatus = dto.getBizStatus();
          this.businessType = dto.getBizType();
          this.englishCompanyName = dto.getEnglishName();
          this.companyHomepage = dto.getHomepage();
          this.companyLogo = dto.getLogoImageUrl();
          this.companyPostCode = dto.getPostCode();
     }
}
