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
@Entity(name="oauth_user")
@Table(name="oauth_user")
public class OAuth2UserEntity {
     @Id
     private String id;
     private Integer employeeCode;
}
