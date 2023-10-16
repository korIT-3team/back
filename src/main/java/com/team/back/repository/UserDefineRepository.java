package com.team.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.team.back.entity.UserDefineViewEntity;
import com.team.back.entity.resultSets.UserDefineListResultSet;

@Repository
public interface UserDefineRepository  extends JpaRepository<UserDefineViewEntity, Integer>   {
  @Query(
      value=
      "SELECT UDD.user_define_detail_code AS userDefineDetailCode, "+
      "UDD.user_define_detail_name AS userDefineDetailName, "+
      "UD.user_define_code AS userDefineCode, "+
      "UD.user_define_name AS userDefineName "+
      "FROM user_define AS UD "+
      "LEFT OUTER JOIN user_define_detail AS UDD ON UD.user_define_code = UDD.user_define_code "+
      "WHERE UD.user_define_code = ?1 "+
      "ORDER BY UDD.user_define_detail_code; ",
      nativeQuery = true
  )

  List<UserDefineListResultSet> getUserDefineList(Integer userDefineCode);
}
