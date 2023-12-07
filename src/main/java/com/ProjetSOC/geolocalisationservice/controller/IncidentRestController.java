package com.ProjetSOC.geolocalisationservice.controller;

import com.ProjetSOC.geolocalisationservice.model.Incident;
import com.ProjetSOC.geolocalisationservice.model.TypeIncident;
import com.ProjetSOC.geolocalisationservice.repository.IncidentRepository;
import com.ProjetSOC.geolocalisationservice.service.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/incidents")
public class IncidentRestController {
    @Autowired
    IncidentService incidentService ;
    @Autowired
    private IncidentRepository incidentRepository;
    @RequestMapping(method = RequestMethod.POST)

    public Incident ajoutIncident(@RequestBody Incident incident){
        return incidentService.ajouterIncident(incident);
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<Incident> afficherIncidents(){
        return incidentService.afficherIncidents();
    }
    @RequestMapping(value = "/{id}",method=RequestMethod.DELETE)
    public void supprimerIncident(@PathVariable("id") Long id){

        incidentService.supprimerById(id);
    }
    @GetMapping("/nonverifes")
    public List<Incident> getIncidentsEnAttente() {
        return incidentService.getIncidentsNonVerifes();
    }

    @GetMapping("/verifes")
    public List<Incident> getIncidentsVerifies() {
        return incidentService.getIncidentsVerifies();
    }

    @GetMapping("/rejetes")
    public List<Incident> getIncidentsRejetes() {
        return incidentService.getIncidentsRejetes();
    }
    @PutMapping("/{id}/accepter")
    public Incident accepterIncident(@PathVariable Long id) {
        return incidentService.accepterIncident(id);
    }

    @PutMapping("/{id}/refuser")
    public Incident refuserIncident(@PathVariable Long id) {
        return incidentService.refuserIncident(id);
    }
    @GetMapping("/{lieu}")
    public List<Incident> listerIncidentsParLieu(@PathVariable String lieu) {
        return incidentService.listerIncidentParLieu(lieu);
    }
    @GetMapping("/{type}")
    public List<Incident> listerIncidentsParType(@PathVariable TypeIncident type) {
        return incidentService.listerIncidentParType(type);
    }
}
