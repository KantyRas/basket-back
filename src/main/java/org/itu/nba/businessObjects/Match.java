package org.itu.nba.businessObjects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;

@Entity
@Table(name = "match")
public class Match {
    @Id
    int id;
    Timestamp date_heure_debut;
    Timestamp date_heure_fin;

    public Match() {
    }

    public Match(Timestamp date_heure_debut, Timestamp date_heure_fin) {
        this.date_heure_debut = date_heure_debut;
        this.date_heure_fin = date_heure_fin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDate_heure_debut() {
        return date_heure_debut;
    }

    public void setDate_heure_debut(Timestamp date_heure_debut) {
        this.date_heure_debut = date_heure_debut;
    }

    public Timestamp getDate_heure_fin() {
        return date_heure_fin;
    }

    public void setDate_heure_fin(Timestamp date_heure_fin) {
        this.date_heure_fin = date_heure_fin;
    }
}
