package com.launchacademy.partyplanner.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "locations")
public class Location {

  @Id
  @SequenceGenerator(name = "locations_generator", sequenceName = "locations_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "locations_generator")
  @Column(name = "id", nullable = false, unique = true)
  private Long id;
  @Column(name = "name")
  @NotBlank(message = "name can't be blank")
  private String name;

  @OneToMany(mappedBy="location")
  @JsonIgnoreProperties("location")
  private Set<Party> parties;
}
