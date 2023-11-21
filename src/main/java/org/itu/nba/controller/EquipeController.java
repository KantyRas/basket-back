package org.itu.nba.controller;

import java.util.List;

import org.itu.nba.businessObjects.Equipe;
import org.itu.nba.repositories.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class EquipeController {

    @Autowired
    EquipeRepository equipeRepository;

    @GetMapping("/equipes")
    public List<Equipe> equipes(){
        return equipeRepository.findAll();
    }
}
