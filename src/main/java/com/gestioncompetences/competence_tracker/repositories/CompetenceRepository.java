package com.gestioncompetences.competence_tracker.repositories;

import com.gestioncompetences.competence_tracker.entities.Competence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetenceRepository extends JpaRepository<Competence, Long> {
}
