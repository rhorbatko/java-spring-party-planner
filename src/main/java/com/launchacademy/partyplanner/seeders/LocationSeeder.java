package com.launchacademy.partyplanner.seeders;

import com.launchacademy.partyplanner.models.Location;
import com.launchacademy.partyplanner.services.LocationService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LocationSeeder {
private LocationService locationService;
@Autowired
  public LocationSeeder(LocationService locationService) {
    this.locationService = locationService;
  }

  public void seed(){
  if(this.locationService.findAll().size()== 0){
    List<String> locations = new ArrayList<>(Arrays.asList("Miami","Cali","San Diego","7-11 parking lot","under the bridge", "at Yousif's"));
    for(String location : locations){
      Location newLocation = new Location();
      newLocation.setName(location);
      locationService.save(newLocation);
    }
  }
  }
}
