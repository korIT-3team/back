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
@Entity(name="employee_list_view")
@Table(name="employee_list_view")
public class EmployeeViewEntity {
     private int no;
     @Id
     private int employeeCode;
     private String employeeName;
     private String genderName;
     private String departmentName;
     private String position;
     private String email;
     private String employmentType;
}
