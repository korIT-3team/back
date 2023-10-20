package com.team.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.team.back.entity.UserDefineDetailEntity;

@Repository
public interface UserDefineDetailRepository extends JpaRepository<UserDefineDetailEntity, Integer>  {
     @Query(
          value=
               "SELECT * " +
               "FROM user_define_detail " +
               "WHERE user_define_code = 9009; ",
               nativeQuery=true 
     )
     List<UserDefineDetailEntity> getInvoiceType();

     @Query(
          value=
               "SELECT * " +
               "FROM user_define_detail " +
               "WHERE user_define_code = 9003; ",
               nativeQuery=true 
     )
     List<UserDefineDetailEntity> getEmploymentType();

     @Query(
          value=
               "SELECT * " +
               "FROM user_define_detail " +
               "WHERE user_define_code = 9008; ",
               nativeQuery=true 
     )
     List<UserDefineDetailEntity> getIncentiveType();
}
