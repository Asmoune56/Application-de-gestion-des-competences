package com.gestioncompetences.competence_tracker.repositories;

import com.gestioncompetences.competence_tracker.entities.SousCompetence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SousCompetenceRepository extends JpaRepository<SousCompetence, Long> {
}

