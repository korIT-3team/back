package com.team.back.entity.resultSets;

public interface SystemEmployeeListResultSet {
  int getNo();
  int getSystemEmployeeCode();
  String getSystemEmployeeName();
  String getSystememployeeGender();
  int getSystemEmployeeGenderCode();
  String getSystemEmployeeDepartmentName();
  int getSystemEmployeeDepartmentCode();
  String getSystemEmployeeJoinDate();
  String getSystemEmployeeResignationDate();
  String getSystemEmployeePassword();
  String getSystemEmployeeRegistrationNumber();
  String getSystemEmployeeEmploymentType();
  int getSystemEmployeeEmploymentTypeCode();
}
