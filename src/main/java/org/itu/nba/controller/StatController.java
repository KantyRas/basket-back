package org.itu.nba.controller;

import java.sql.Timestamp;
import java.util.List;

import org.itu.nba.businessObjects.StatEquipe;
import org.itu.nba.services.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class StatController {
    @Autowired
    StatService service;

    @PostMapping("/{action}")
    public void saveStat(@PathVariable("action") String table,
            @RequestParam("idMatch") String id_match,
            @RequestParam("idJoueur") String id_joueur) {
        int idMatch = Integer.valueOf(id_match);
        int idJoueur = Integer.valueOf(id_joueur);
        service.save(idMatch, idJoueur, table);
    }

    @PostMapping("/entreeSortie")
    public void entreeSortie(
            @RequestParam("idMatch") String idMatch,
            @RequestParam("idJoueur") String idJoueur,
            @RequestParam("entree") String entree,
            @RequestParam("sortie") String sortie) {

        int id_match = Integer.valueOf(idMatch);
        int id_joueur = Integer.valueOf(idJoueur);
        Timestamp entreeTimestamp = Timestamp.valueOf(entree);
        Timestamp sortieTimestamp = Timestamp.valueOf(sortie);

        service.entreeSortie(id_match, id_joueur, entreeTimestamp, sortieTimestamp);
    }

    @GetMapping("/{idEquipe}")
    public List<StatEquipe> stats( @PathVariable("idEquipe") String idEquipe) {
        int id_equipe = Integer.valueOf(idEquipe);
        return service.getAllStats(id_equipe);
    }

}
