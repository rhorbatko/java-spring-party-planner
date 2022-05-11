package com.launchacademy.partyplanner.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MainSeeder implements CommandLineRunner {

  private LocationSeeder locationSeeder;
  private PartySeeder partySeeder;

  @Autowired
  public MainSeeder(LocationSeeder locationSeeder, PartySeeder partySeeder) {
    this.locationSeeder = locationSeeder;
    this.partySeeder = partySeeder;
  }

  @Override
  public void run(String... args) throws Exception {
    //run seeders here
    locationSeeder.seed();
    partySeeder.seed();
    //For example locationSeeder.seed()
  }
}
