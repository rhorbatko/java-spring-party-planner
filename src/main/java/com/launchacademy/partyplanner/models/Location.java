package com.launchacademy.partyplanner.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Set;
import javax.persistence.*;
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

  @OneToMany(mappedBy="location", fetch = FetchType.EAGER)
  @JsonIgnoreProperties("location")
  private Set<Party> parties;
}
