package com.launchacademy.partyplanner.exceptionHandling;

public class LocationNotFoundException extends RuntimeException{
  public LocationNotFoundException(){
    super("No location found with provided ID");
  }
}
