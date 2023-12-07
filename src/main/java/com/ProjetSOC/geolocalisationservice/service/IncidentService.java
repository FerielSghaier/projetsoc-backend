package com.ProjetSOC.geolocalisationservice.service;

import com.ProjetSOC.geolocalisationservice.model.Incident;
import com.ProjetSOC.geolocalisationservice.model.TypeIncident;

import java.util.List;

public interface IncidentService {
    Incident ajouterIncident (Incident incident);
    List<Incident> afficherIncidents();
    void supprimerById(Long id);
    List<Incident> getIncidentsNonVerifes();
    List<Incident> getIncidentsVerifies();
    List<Incident> getIncidentsRejetes();
    Incident accepterIncident(Long id);
    Incident refuserIncident(Long id);
    List<Incident> listerIncidentParLieu(String Lieu);
    List<Incident> listerIncidentParType(TypeIncident type);
}
