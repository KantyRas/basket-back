package org.itu.nba.controller;

import org.itu.nba.businessObjects.Equipe;
import org.itu.nba.businessObjects.Match;
import org.itu.nba.repositories.MatchRepository;
import org.itu.nba.services.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
@RequestMapping("/matchs")
public class MatchController {
    @Autowired
    MatchRepository repository;
    private StatService MacthRepository;

    @PostMapping
    public void inserer_match(
            @RequestParam("id") String id,
            @RequestParam("date_debut") String date_heure_debut,
            @RequestParam("date_fin") String date_heure_fin
    ){
        Match m=new Match();
        m.setId(Integer.valueOf(id));
        m.setDate_heure_debut(Timestamp.valueOf(date_heure_debut));
        m.setDate_heure_fin(Timestamp.valueOf(date_heure_fin));
        this.repository.save(m);
    }
}
