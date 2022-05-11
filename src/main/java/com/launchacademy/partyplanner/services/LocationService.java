package com.launchacademy.partyplanner.services;

import com.launchacademy.partyplanner.models.Location;
import java.util.List;
import java.util.Optional;

public interface LocationService {
List<Location> findAll();

  void save(Location newLocation);

  Optional<Location> findById(Long id);
}
