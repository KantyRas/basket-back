package org.itu.nba.repositories;

import org.itu.nba.businessObjects.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipeRepository extends JpaRepository<Equipe , Integer>{
    
}
