package com.launchacademy.partyplanner.seeders;

import com.launchacademy.partyplanner.models.Location;
import com.launchacademy.partyplanner.models.Party;
import com.launchacademy.partyplanner.services.LocationService;
import com.launchacademy.partyplanner.services.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PartySeeder {
private LocationService locationService;
private PartyService partyService;

  @Autowired
  public PartySeeder(LocationService locationService,
      PartyService partyService) {
    this.locationService = locationService;
    this.partyService = partyService;
  }

  public void seed(){
    Location location1 = locationService.findById(1L).get();
    Location location2 = locationService.findById(2L).get();
    Location location3 = locationService.findById(3L).get();
  if(partyService.count() == 0){
    Party party1 = new Party();
    party1.setName("Beach night");
    party1.setDescription("All night long");
    party1.setLocation(location1);

    Party party2 = new Party();
    party2.setName("Street light");
    party2.setDescription("Next street");
    party2.setLocation(location2);

    Party party3 = new Party();
    party3.setName("U F P");
    party3.setDescription("union party");
    party3.setLocation(location2);

    Party party4 = new Party();
    party4.setName("I don't have a name");
    party4.setDescription("give me a name");
    party4.setLocation(location3);

    partyService.save(party1);
    partyService.save(party2);
    partyService.save(party3);
    partyService.save(party4);
  }
  }
}
