package com.team.back.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
  
  @PostMapping("")
  public String hello() {
    return "Hello";
  }

}
