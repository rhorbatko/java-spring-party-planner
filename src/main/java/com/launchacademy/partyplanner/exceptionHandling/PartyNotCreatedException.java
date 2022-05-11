package com.launchacademy.partyplanner.exceptionHandling;

public class PartyNotCreatedException extends RuntimeException{
  public PartyNotCreatedException(){super("Failed to create Party");}
}
