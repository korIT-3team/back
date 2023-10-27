package com.team.back.entity.resultSets;

public interface IncentiveListResultSet {
  int getNo();
  int getIncentiveCode();
  String getEmployeeName();
  int getEmployeeCode();
  String getIncentiveCategoryName();
  int getIncentiveCategoryCode();
  String getPaymentDate();
  double getIncentivePrice();
  String getContent();
}
