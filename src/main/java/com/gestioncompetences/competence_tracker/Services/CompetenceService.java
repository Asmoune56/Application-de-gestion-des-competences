package com.gestioncompetences.competence_tracker.Services;

import com.gestioncompetences.competence_tracker.Repositories.CompetenceRepository;
import com.gestioncompetences.competence_tracker.entities.Competence;
import com.gestioncompetences.competence_tracker.entities.SousCompetence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompetenceService {

    private final CompetenceRepository competenceRepository;

    public Competence save(Competence competence) {
        long total = competence.getSousCompetences().size();
        long validées = competence.getSousCompetences().stream().filter(SousCompetence::isValidee).count();
        competence.setAcquise(validées == total);
        return competenceRepository.save(competence);
    }

    public List<Competence> getAll() {
        return competenceRepository.findAll();
    }

    public void delete(Long id) {
        competenceRepository.deleteById(id);
    }


}
