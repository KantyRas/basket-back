package org.itu.nba.services;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.Timestamp;

import org.itu.nba.DAO.DAO;
import org.itu.nba.businessObjects.Equipe;
import org.itu.nba.businessObjects.Joueur;
import org.itu.nba.businessObjects.Match;
import org.itu.nba.repositories.EquipeRepository;
import org.itu.nba.repositories.JoueurRepository;
import org.itu.nba.repositories.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneralService {
    @Autowired
    JoueurRepository joueurRepository;

    @Autowired
    EquipeRepository equipeRepository;

    @Autowired
    MatchRepository matchRepository;

    @Autowired
    DAO dao;

    public void saveJoueur(String nom) {
        Joueur data = new Joueur(nom);

        joueurRepository.save(data);
    }

    public void saveEquipe(String nom) {
        Equipe data = new Equipe(nom);

        equipeRepository.save(data);
    }

    public void saveMatch(Timestamp date_heure_debut, Timestamp date_heure_fin) {
        Match data = new Match(date_heure_debut, date_heure_fin);

        matchRepository.save(data);
    }

    public void setComposition(int idMatch, int idEquipe, int idJoueur) {
        try {
            Connection conn = dao.connect();
            String sql = String.format("INSERT INTO composition_equipe VALUE( %s , %s , %s ) ", idMatch,
                    idEquipe, idJoueur);

            Statement stmt = conn.createStatement();

            stmt.executeUpdate(sql);

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
