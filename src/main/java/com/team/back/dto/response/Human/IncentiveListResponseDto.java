package com.team.back.dto.response.human;

import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.resultSets.IncentiveListResultSet;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class IncentiveListResponseDto {
  private int no;
  private int incentiveCode;
  private String employeeName;
  private int employeeCode;
  private String incentiveCategoryName;
  private int incentiveCategoryCode;
  private String paymentDate;
  private double incentivePrice;
  private String content;

  public IncentiveListResponseDto (IncentiveListResultSet resultSet) {
    this.no = resultSet.getNo();
    this.incentiveCode = resultSet.getIncentiveCode();
    this.employeeName = resultSet.getEmployeeName();
    this.employeeCode = resultSet.getEmployeeCode();
    this.incentiveCategoryName = resultSet.getIncentiveCategoryName();
    this.incentiveCategoryCode = resultSet.getIncentiveCategoryCode();
    this.paymentDate = resultSet.getPaymentDate();
    this.incentivePrice = resultSet.getIncentivePrice();
    this.content = resultSet.getContent();
  }

  public static List<IncentiveListResponseDto> copyList(List<IncentiveListResultSet> resultSets) {
    List<IncentiveListResponseDto> incentiveList = new ArrayList<>();

    for (IncentiveListResultSet resultSet : resultSets) {
      IncentiveListResponseDto incentive = new IncentiveListResponseDto(resultSet);
      incentiveList.add(incentive);
    }

    return incentiveList;
  }
}
