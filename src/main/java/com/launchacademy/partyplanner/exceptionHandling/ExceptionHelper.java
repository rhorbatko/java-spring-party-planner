package com.launchacademy.partyplanner.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHelper {
  @ExceptionHandler(value = {LocationNotFoundException.class})
  public ResponseEntity<String> handleLocationNotFoundException(LocationNotFoundException ex) {
    System.out.println("Hit the LocationNotFoundException");
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = {LocationNotCreatedException.class})
  public ResponseEntity<String> handleLocationNotCreatedException(LocationNotCreatedException ex) {
    System.out.println("Hit The LocationNotCreatedException");
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = {PartyNotCreatedException.class})
  public ResponseEntity<String> handlePartyNotCreatedException(PartyNotCreatedException ex) {
    System.out.println("Hit The PartyNotCreatedException");
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
  }
}
