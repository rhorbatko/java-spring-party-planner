package com.launchacademy.partyplanner.repositories;

import com.launchacademy.partyplanner.models.Party;
import org.springframework.data.repository.CrudRepository;

public interface PartyRepository extends CrudRepository<Party, Long> {

}
