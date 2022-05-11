package com.launchacademy.partyplanner.services;

import com.launchacademy.partyplanner.models.Location;
import com.launchacademy.partyplanner.repositories.LocationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class LocationDatabaseService implements LocationService{
private LocationRepository locationRepo;

  public LocationDatabaseService(
      LocationRepository locationRepo) {
    this.locationRepo = locationRepo;
  }

  @Override
  public List<Location> findAll() {
    return (List<Location>)locationRepo.findAll();
  }

  @Override
  public void save(Location newLocation) {
    locationRepo.save(newLocation);
  }

  @Override
  public Optional<Location> findById(Long id) {
    return locationRepo.findById(id);
  }
}
