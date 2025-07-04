package com.gestioncompetences.competence_tracker.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SousCompetence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private boolean estValidee;

    @ManyToOne
    private Competence competence;

    // Getters
    public Long getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }
    public boolean isEstValidee() {
        return estValidee;
    }
    public Competence getCompetence() {
        return competence;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setEstValidee(boolean estValidee) {
        this.estValidee = estValidee;
    }
    public void setCompetence(Competence competence) {
        this.competence = competence;
    }
}



