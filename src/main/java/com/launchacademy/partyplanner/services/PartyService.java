package com.launchacademy.partyplanner.services;

import com.launchacademy.partyplanner.models.Party;
import com.launchacademy.partyplanner.models.PartyForm;

import java.util.List;

public interface PartyService {
List<Party> findAll();

void save(Party party);

  Long count();

  Party createParty(PartyForm partyForm);
}
