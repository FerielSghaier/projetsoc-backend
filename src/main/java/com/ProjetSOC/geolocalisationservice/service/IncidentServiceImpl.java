package com.ProjetSOC.geolocalisationservice.service;

import com.ProjetSOC.geolocalisationservice.model.Incident;
import com.ProjetSOC.geolocalisationservice.model.TypeIncident;
import com.ProjetSOC.geolocalisationservice.repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class IncidentServiceImpl implements IncidentService{
    @Autowired
    IncidentRepository incidentRepository;
    @Override
    public Incident ajouterIncident(Incident incident) {
        Incident incident1 = new Incident();
        incident1.setType(incident.getType());
        incident1.setDate(incident.getDate());
        incident1.setHeure(incident.getHeure());
        incident1.setLieu(incident.getLieu());
        incident1.setDescription(incident.getDescription());

        return incidentRepository.save(incident1);
    }

    @Override
    public List<Incident> afficherIncidents() {
        return incidentRepository.findAll();
    }

    @Override
    public void supprimerById(Long id) {
        incidentRepository.deleteById(id);
    }

    @Override
    public List<Incident> getIncidentsNonVerifes() {
        return incidentRepository.findByVerifie(null);
    }

    @Override
    public List<Incident> getIncidentsVerifies() {
        return incidentRepository.findByVerifie(true);
    }

    @Override
    public List<Incident> getIncidentsRejetes() {
        return incidentRepository.findByVerifie(false);
    }

    @Override
    public Incident accepterIncident(Long id) {
        Incident incident = incidentRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Demande non trouvée"));
        incident.setVerifie(true);
        return incidentRepository.save(incident);
    }

    @Override
    public Incident refuserIncident(Long id) {
        Incident incident = incidentRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Demande non trouvée"));
        incident.setVerifie(false);
        return incidentRepository.save(incident);
    }

    @Override
    public List<Incident> listerIncidentParLieu(String lieu) {
        List<Incident> incidents = incidentRepository.findByLieu(lieu);

        return incidents;
    }

    @Override
    public List<Incident> listerIncidentParType(TypeIncident type) {
        List<Incident> incidents = incidentRepository.findByType(type);

        return incidents;
    }
}
