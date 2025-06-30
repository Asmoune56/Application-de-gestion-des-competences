package com.gestioncompetences.competence_tracker.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Competence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String description;

    private boolean acquise;

    @OneToMany(mappedBy = "competence", cascade = CascadeType.ALL)
    private List<SousCompetence> sousCompetences;
}
