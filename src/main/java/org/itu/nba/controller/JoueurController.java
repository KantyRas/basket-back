package org.itu.nba.controller;

import org.itu.nba.businessObjects.Joueur;
import org.itu.nba.repositories.JoueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/joueurs")
public class JoueurController {
    @Autowired
    JoueurRepository repository;
    @PostMapping
    public void inserer_joueur(
            @RequestParam("id") String id,
            @RequestParam("nom") String nom
    ){
        Joueur temp = new Joueur();
        temp.setId(Integer.valueOf(id));
        temp.setNom(nom);

        this.repository.save(temp);
    }
}
