package com.ProjetSOC.geolocalisationservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TypeIncident type;


    private LocalDate date;

    private LocalTime heure;

    private String lieu;

    private String description;

    private Boolean verifie=null; // si verifie = null => incident en attente
    // si verifie = false => incident refusée
    // si verifie = true => incident acceptée
}
