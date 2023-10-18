package com.team.back.entity.resultSets;

public interface SystemEmployeeListResultSet {
  int getNo();
  int getEmployeeCode();
  String getEmployeeName();
  String getEmployeeGender();
  int getEmployeeGenderCode();
  String getEmployeeDepartmentName();
  int getEmployeeDepartmentCode();
  String getEmployeeJoinDate();
  String getEmployeeResignationDate();
  String getEmployeePassword();
  String getEmployeeRegistrationNumber();
  String getEmployeeEmploymentType();
  int getEmployeeEmploymentTypeCode();
}
