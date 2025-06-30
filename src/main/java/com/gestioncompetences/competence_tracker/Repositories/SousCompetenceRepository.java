package com.gestioncompetences.competence_tracker.Repositories;

import com.gestioncompetences.competence_tracker.entities.SousCompetence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SousCompetenceRepository extends JpaRepository<SousCompetence, Long> {
}

