package com.launchacademy.partyplanner.services;

import com.launchacademy.partyplanner.models.Location;
import com.launchacademy.partyplanner.models.Party;
import com.launchacademy.partyplanner.models.PartyForm;
import com.launchacademy.partyplanner.repositories.PartyRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartyDatabaseService implements PartyService{
private PartyRepository partyRepo;
private LocationService locationService;

@Autowired
  public PartyDatabaseService(PartyRepository partyRepo, LocationService locationService) {
    this.partyRepo = partyRepo;
    this.locationService = locationService;
  }

  @Override
  public List<Party> findAll() {
    return (List<Party>) partyRepo.findAll();
  }

  @Override
  public void save(Party party) {
   partyRepo.save(party);
  }

  @Override
  public Long count() {
    return  partyRepo.count();
  }

  @Override
  public Party createParty(PartyForm partyForm) {
    Party newParty = new Party();
    newParty.setName(partyForm.getName());
    newParty.setDescription(partyForm.getDescription());
    Optional <Location> location = locationService.findById(partyForm.getLocationId());
    if(location.isPresent()) {
      newParty.setLocation(location.get());
    }
    return partyRepo.save(newParty);
  }
}
