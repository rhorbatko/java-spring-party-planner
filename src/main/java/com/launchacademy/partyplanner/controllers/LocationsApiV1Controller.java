package com.launchacademy.partyplanner.controllers;

import com.launchacademy.partyplanner.exceptionHandling.LocationNotCreatedException;
import com.launchacademy.partyplanner.exceptionHandling.LocationNotFoundException;
import com.launchacademy.partyplanner.models.Location;
import com.launchacademy.partyplanner.services.LocationService;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/locations")
public class LocationsApiV1Controller {
private LocationService locationService;
@Autowired
  public LocationsApiV1Controller(
      LocationService locationService) {
    this.locationService = locationService;
  }

  @GetMapping
  public ResponseEntity<Map<String,Iterable<Location>>> getLocations(){
    Map<String,Iterable<Location>> dataMap = new HashMap<>();
    dataMap.put("locations", locationService.findAll());
    return new ResponseEntity<Map<String, Iterable<Location>>>(dataMap, HttpStatus.OK);
  }
  @GetMapping("/{id}")
  public ResponseEntity<Map<String, Location>> getLocation(@PathVariable Long id){
  Map <String, Location> locationDataMap = new HashMap<>();
  Optional<Location> location = locationService.findById(id);
  if(location.isPresent()){
    locationDataMap.put("location",location.get());
  }else{
    throw new LocationNotFoundException();
  }
  return new ResponseEntity<>(locationDataMap, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Map<String, Location>> create(@RequestBody Location location) {
    try {
      locationService.save(location);
      Map<String, Location> dataMap = new HashMap<>();
      dataMap.put("location", location);
      return new ResponseEntity<>(dataMap, HttpStatus.CREATED);
    } catch (IllegalArgumentException ex) {
      System.out.println("Could not create location");
      throw new LocationNotCreatedException();
    }
  }
}
