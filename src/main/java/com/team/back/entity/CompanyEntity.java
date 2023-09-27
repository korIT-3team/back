package com.team.back.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
}
