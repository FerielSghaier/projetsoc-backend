package com.ProjetSOC.geolocalisationservice.repository;

import com.ProjetSOC.geolocalisationservice.model.Incident;
import com.ProjetSOC.geolocalisationservice.model.TypeIncident;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncidentRepository extends JpaRepository<Incident, Long> {
    List<Incident> findByVerifie(Boolean verifie);
    List<Incident> findByLieu(String lieu);
    List<Incident> findByType(TypeIncident type);
}
