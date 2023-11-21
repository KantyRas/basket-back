package org.itu.nba.repositories;

import org.itu.nba.businessObjects.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JoueurRepository extends JpaRepository<Joueur , Integer>{
    
}
