package org.itu.nba.businessObjects;

import org.springframework.stereotype.Component;

@Component
public class CompositionEquipe {
    int idMatch;
    int[] equipes;
    int[][] joueurs;

    public CompositionEquipe() {
    }

    public CompositionEquipe(int idMatch, int[] equipes, int[][] joueurs) {
        this.idMatch = idMatch;
        this.equipes = equipes;
        this.joueurs = joueurs;
    }

    public int getIdMatch() {
        return idMatch;
    }

    public void setIdMatch(int idMatch) {
        this.idMatch = idMatch;
    }

    public int[] getEquipes() {
        return equipes;
    }

    public void setEquipes(int[] equipes) {
        this.equipes = equipes;
    }

    public int[][] getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(int[][] joueurs) {
        this.joueurs = joueurs;
    }
}
