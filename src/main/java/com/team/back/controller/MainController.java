package com.team.back.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class MainController {

  // API: 서버 오픈 여부 확인 메서드 //
  @GetMapping("")
  public String isServer() {
    return "Server On...";
  }
  
}
