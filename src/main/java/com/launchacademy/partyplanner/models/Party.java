package com.launchacademy.partyplanner.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "parties")
public class Party {

  @Id
  @SequenceGenerator(name = "party_generator", sequenceName = "parties_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "party_generator")
  @Column(name = "id", nullable = false, unique = true)
  private Long id;
  @Column(name = "name")
  @NotBlank(message = "name can't be blank")
  private String name;
  @Column(name = "description")
  @NotBlank(message = "description can't be blank")
  private String description;

  @ManyToOne
  @JoinColumn(name="location_id", nullable=false)
  @JsonIgnoreProperties("parties")
  private Location location;
}
