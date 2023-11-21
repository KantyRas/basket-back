package org.itu.nba.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.itu.nba.DAO.DAO;
import org.itu.nba.businessObjects.Stat;
import org.itu.nba.businessObjects.StatEquipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatService {
    @Autowired
    DAO dao;

    public void save(int id_match, int id_joueur, String table) {
        try {
            Connection conn = dao.connect();
            String sql = String.format("INSERT INTO %s VALUES( %s , %s ) ",table , id_match, id_joueur);

            Statement stmt = conn.createStatement();

            stmt.executeUpdate(sql);

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void entreeSortie(int idMatch, int idJoueur, Timestamp entree, Timestamp sortie) {
        try {
            Connection conn = dao.connect();
            String sql = String.format("INSERT INTO detail_entree_sortie_joueur VALUE( %s , %s , %s ,%s ) ", idMatch,
                    idJoueur, entree, sortie);

            Statement stmt = conn.createStatement();

            stmt.executeUpdate(sql);

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Stat> getAll(String stat) {
        List<Stat> stats = new ArrayList<>();
        try {
            Connection conn = dao.connect();
            String sql = String.format("SELECT * FROM %s", stat);

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Stat temp = new Stat(rs.getInt("id_match"), rs.getInt("id_joueur"), stat);
                stats.add(temp);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stats;
    }

    public List<StatEquipe> getAllStats(int idEquipe) {
        List<StatEquipe> results = new ArrayList<>();

        try {
            Connection conn = dao.connect();
            String sql = String.format("SELECT * FROM get_team_stats(%s)", idEquipe);

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                StatEquipe temp = new StatEquipe();

                temp.setIdMatch(rs.getInt(1));
                temp.setIdJoueur(rs.getInt(2));
                temp.setJoueur(rs.getString(3));

                temp.setDebut(rs.getTimestamp(4));
                temp.setFin(rs.getTimestamp(5));

                temp.setDeuxPts(rs.getInt(6));
                temp.setTroisPts(rs.getInt(7));

                temp.setRebind(rs.getInt(8));
                temp.setPasseDecisive(rs.getInt(9));
                temp.setInterception(rs.getInt(10));

                temp.setMinuteJouee(rs.getDouble(11));

                results.add(temp);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }
}
