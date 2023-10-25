package com.team.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team.back.entity.Oauth.OAuth2UserEntity;


public interface OAuth2Repository extends JpaRepository<OAuth2UserEntity, Integer> {
     boolean existsById(String id);
     OAuth2UserEntity findById(String id);
     
}
