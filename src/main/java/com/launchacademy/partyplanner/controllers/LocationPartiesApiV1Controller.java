package com.launchacademy.partyplanner.controllers;

import com.launchacademy.partyplanner.exceptionHandling.LocationNotCreatedException;
import com.launchacademy.partyplanner.exceptionHandling.PartyNotCreatedException;
import com.launchacademy.partyplanner.models.Party;
import com.launchacademy.partyplanner.models.PartyForm;
import com.launchacademy.partyplanner.services.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/parties")
public class LocationPartiesApiV1Controller {
  private PartyService partyService;

  @Autowired
  public LocationPartiesApiV1Controller(PartyService partyService) {
    this.partyService = partyService;
  }

  @PostMapping
  public ResponseEntity<Map<String, Party>> create(@RequestBody PartyForm partyForm) {
    try {
      Party newParty = partyService.createParty(partyForm);
      Map<String, Party> dataMap = new HashMap<>();
      dataMap.put("party", newParty);
      return new ResponseEntity<>(dataMap, HttpStatus.CREATED);
    } catch (PartyNotCreatedException e) {
      System.out.println("Could not create Party");
      throw new PartyNotCreatedException();
    }
  }
}
