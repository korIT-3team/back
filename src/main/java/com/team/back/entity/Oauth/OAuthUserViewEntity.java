package com.team.back.entity.Oauth;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="oauth_user_view")
@Table(name="oauth_user_view")
public class OAuthUserViewEntity {
     @Id
     private Integer employeeCode;
     private String id;
     private String employeeName;
     private Integer departmentCode;
     private String departmentName;
}
