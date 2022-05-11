package com.launchacademy.partyplanner.services;

import com.launchacademy.partyplanner.models.Party;
import com.launchacademy.partyplanner.repositories.PartyRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class PartyDatabaseService implements PartyService{
private PartyRepository partyRepo;

@Autowired
  public PartyDatabaseService(PartyRepository partyRepo) {
    this.partyRepo = partyRepo;
  }

  @Override
  public List<Party> findAll() {
    return (List<Party>) partyRepo.findAll();
  }

  @Override
  public void save(Party party) {
   partyRepo.save(party);
  }
}
