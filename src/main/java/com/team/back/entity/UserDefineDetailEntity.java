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
@Entity(name="user_define_detail")
@Table(name="user_define_detail")
public class UserDefineDetailEntity {
     @Id
     private int userDefineDetailCode;
     private String userDefineDetailName;
}
