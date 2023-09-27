package com.team.back.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
     //! todo : 사원등록을 코드상에서 할땐 auto increment 컬럼이므로 주석풀고
     // @GeneratedValue(strategy=GenerationType.IDENTITY)
     private int employeeCode;
     private String employeeName;
     private int departmentCode;
     private String password;
}
