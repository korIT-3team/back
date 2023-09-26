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
@Entity(name = "employee")
@Table(name = "employee")
public class UserEntity {
     @Id
     private int employeeCode;
     private String employeeName;
     private int departmentCode;
     private String password;
}