package org.itu.nba.repositories;

import org.itu.nba.businessObjects.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match , Integer>{
    
}
