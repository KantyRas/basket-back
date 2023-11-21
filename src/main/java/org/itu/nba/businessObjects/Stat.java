package org.itu.nba.businessObjects;

import org.springframework.stereotype.Component;

@Component
public class Stat {
    int id_match;
    int id_joueur;
    String forTable;

    public Stat(int id_match, int id_joueur, String forTable) {
        this.id_match = id_match;
        this.id_joueur = id_joueur;
        this.forTable = forTable;
    }



    public Stat(int id_match, int id_joueur) {
        this.id_match = id_match;
        this.id_joueur = id_joueur;
    }

    

    public Stat() {
    }

    public int getId_match() {
        return id_match;
    }

    public void setId_match(int id_match) {
        this.id_match = id_match;
    }

    public int getId_joueur() {
        return id_joueur;
    }

    public void setId_joueur(int id_joueur) {
        this.id_joueur = id_joueur;
    }

    public String getForTable() {
        return forTable;
    }

    public void setForTable(String forTable) {
        this.forTable = forTable;
    }

}
