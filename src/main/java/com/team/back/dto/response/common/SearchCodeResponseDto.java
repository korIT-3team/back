package com.team.back.dto.response.common;
import java.util.ArrayList;
import java.util.List;

import com.team.back.entity.resultSets.SearchCodeResultSet;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SearchCodeResponseDto {
     private int no;
     private int detailCode;
     private String name;

     public SearchCodeResponseDto(SearchCodeResultSet resultSet){
          this.no = resultSet.getNo();
          this.detailCode = resultSet.getDetailCode();
          this.name = resultSet.getName();
     }
     
     public static List<SearchCodeResponseDto> copyList(List<SearchCodeResultSet> resultSets) {
          List<SearchCodeResponseDto> searchCodeList = new ArrayList<>();

          for (SearchCodeResultSet resultSet : resultSets) {
               SearchCodeResponseDto dto = new SearchCodeResponseDto(resultSet);
               searchCodeList.add(dto);
          }

          return searchCodeList;
     }
}
