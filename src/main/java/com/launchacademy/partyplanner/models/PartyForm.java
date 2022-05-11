package com.launchacademy.partyplanner.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@NoArgsConstructor
@Getter
@Setter
@Component
public class PartyForm {

  @NotBlank
 private String name;

 private String description;

 @NotNull
 private Long locationId;
}
