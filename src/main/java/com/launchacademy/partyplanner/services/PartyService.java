package com.launchacademy.partyplanner.services;

import com.launchacademy.partyplanner.models.Party;
import java.util.List;

public interface PartyService {
List<Party> findAll();

void save(Party party);

}
