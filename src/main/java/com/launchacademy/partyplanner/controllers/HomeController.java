package com.launchacademy.partyplanner.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping(value = {"/locations"})
  public String forward() {
    return "forward:/";
  }
}
