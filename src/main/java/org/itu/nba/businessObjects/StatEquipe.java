package org.itu.nba.businessObjects;

import java.sql.Timestamp;

public class StatEquipe {
    int idMatch;
    int idJoueur;
    String joueur;
    Timestamp debut;
    Timestamp fin;
    int tir;
    int deuxPts;
    int troisPts;
    int rebind;
    int passeDecisive;
    int interception;
    double minuteJouee;

    public StatEquipe(int idMatch, int idJoueur, String joueur, Timestamp debut, Timestamp fin, int tir, int deuxPts,
            int troisPts, int rebind, int passeDecisive, int interception, double minuteJouee) {
        this.idMatch = idMatch;
        this.idJoueur = idJoueur;
        this.joueur = joueur;
        this.debut = debut;
        this.fin = fin;
        this.tir = tir;
        this.deuxPts = deuxPts;
        this.troisPts = troisPts;
        this.rebind = rebind;
        this.passeDecisive = passeDecisive;
        this.interception = interception;
        this.minuteJouee = minuteJouee;
    }

    public StatEquipe() {
    }

    public int getIdMatch() {
        return idMatch;
    }

    public void setIdMatch(int idMatch) {
        this.idMatch = idMatch;
    }

    public int getIdJoueur() {
        return idJoueur;
    }

    public void setIdJoueur(int idJoueur) {
        this.idJoueur = idJoueur;
    }

    public String getJoueur() {
        return joueur;
    }

    public void setJoueur(String joueur) {
        this.joueur = joueur;
    }

    public Timestamp getDebut() {
        return debut;
    }

    public void setDebut(Timestamp debut) {
        this.debut = debut;
    }

    public Timestamp getFin() {
        return fin;
    }

    public void setFin(Timestamp fin) {
        this.fin = fin;
    }

    public int getTir() {
        return tir;
    }

    public void setTir(int tir) {
        this.tir = tir;
    }

    public int getDeuxPts() {
        return deuxPts;
    }

    public void setDeuxPts(int deuxPts) {
        this.deuxPts = deuxPts;
    }

    public int getTroisPts() {
        return troisPts;
    }

    public void setTroisPts(int troisPts) {
        this.troisPts = troisPts;
    }

    public int getRebind() {
        return rebind;
    }

    public void setRebind(int rebind) {
        this.rebind = rebind;
    }

    public int getPasseDecisive() {
        return passeDecisive;
    }

    public void setPasseDecisive(int passeDecisive) {
        this.passeDecisive = passeDecisive;
    }

    public int getInterception() {
        return interception;
    }

    public void setInterception(int interception) {
        this.interception = interception;
    }

    public double getMinuteJouee() {
        return minuteJouee;
    }

    public void setMinuteJouee(double minuteJouee) {
        this.minuteJouee = minuteJouee;
    }

}
