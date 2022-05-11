package com.launchacademy.partyplanner.exceptionHandling;

public class LocationNotCreatedException extends RuntimeException{
  public LocationNotCreatedException (){super("Could not create Location");}
}
