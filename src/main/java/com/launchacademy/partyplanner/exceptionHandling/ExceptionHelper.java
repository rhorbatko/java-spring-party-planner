package com.launchacademy.partyplanner.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHelper {
@ExceptionHandler(value = {LocationNotFoundException.class})
  public ResponseEntity<String> handleLocationNotFoundException(LocationNotFoundException ex){
  System.out.println("Hit the LocationNotFoundException");
  return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
}

}
