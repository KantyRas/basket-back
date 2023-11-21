package org.itu.nba.businessObjects;

import org.springframework.stereotype.Component;

@Component
public class EntreeSortie {
    int id_match;
    int id_joueur;
    int minute_entree;
    int minute_sortie;

    public EntreeSortie() {
    }

    public EntreeSortie(int id_match, int id_joueur, int minute_entree, int minute_sortie) {
        this.id_match = id_match;
        this.id_joueur = id_joueur;
        this.minute_entree = minute_entree;
        this.minute_sortie = minute_sortie;
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

    public int getMinute_entree() {
        return minute_entree;
    }

    public void setMinute_entree(int minute_entree) {
        this.minute_entree = minute_entree;
    }

    public int getMinute_sortie() {
        return minute_sortie;
    }

    public void setMinute_sortie(int minute_sortie) {
        this.minute_sortie = minute_sortie;
    }

}
