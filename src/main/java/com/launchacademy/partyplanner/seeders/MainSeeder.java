package com.launchacademy.partyplanner.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MainSeeder implements CommandLineRunner {

  private LocationSeeder locationSeeder;

  @Autowired
  public MainSeeder(LocationSeeder locationSeeder) {
    this.locationSeeder = locationSeeder;
  }

  @Override
  public void run(String... args) throws Exception {
    //run seeders here
    locationSeeder.seed();
    //For example locationSeeder.seed()
  }
}
