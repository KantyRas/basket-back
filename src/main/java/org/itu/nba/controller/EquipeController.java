package org.itu.nba.controller;

import java.util.List;

import org.itu.nba.businessObjects.Equipe;
import org.itu.nba.repositories.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/equipes")
public class EquipeController {

    @Autowired
    EquipeRepository equipeRepository;

    @GetMapping()
    public List<Equipe> equipes(){
        return equipeRepository.findAll();
    }

    @PostMapping
    public void inserer_joueur(
            @RequestParam("id") String id,
            @RequestParam("nom") String nom
    ){
        Equipe eq=new Equipe();
        eq.setId(Integer.valueOf(id));
        eq.setNom(nom);
        this.equipeRepository.save(eq);
    }

}
