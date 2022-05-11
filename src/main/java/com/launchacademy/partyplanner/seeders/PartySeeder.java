package com.launchacademy.partyplanner.seeders;

import com.launchacademy.partyplanner.services.LocationService;
import com.launchacademy.partyplanner.services.PartyService;

public class PartySeeder {
private LocationService locationService;
private PartyService partyService;

  public PartySeeder(LocationService locationService,
      PartyService partyService) {
    this.locationService = locationService;
    this.partyService = partyService;
  }

  public void seed(){

    if(this.locationService.findAll().size()==0){

    }
  }
}
