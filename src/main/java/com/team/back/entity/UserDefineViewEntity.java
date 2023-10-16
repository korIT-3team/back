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
@Entity(name="user_define_view")
@Table(name="user_define_view")
public class UserDefineViewEntity {
  @Id
  private Integer userDefineCode;
  private String userDefineName;
  private Integer userDefineDetailCode;
  private String userDefineDetailName;
}
