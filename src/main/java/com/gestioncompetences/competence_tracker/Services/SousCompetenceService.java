package com.gestioncompetences.competence_tracker.Services;

import com.gestioncompetences.competence_tracker.dto.SousCompetenceDTO;
import com.gestioncompetences.competence_tracker.mapper.CompetenceMapper;
import com.gestioncompetences.competence_tracker.mapper.SousCompetenceMapper;
import com.gestioncompetences.competence_tracker.repositories.SousCompetenceRepository;
import com.gestioncompetences.competence_tracker.entities.Competence;
import com.gestioncompetences.competence_tracker.entities.SousCompetence;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SousCompetenceService {

    private final SousCompetenceRepository sousCompetenceRepository;
    private final CompetenceService competenceService;
    private final SousCompetenceMapper sousCompetenceMapper;

    public SousCompetenceDTO create(SousCompetenceDTO dto, Long competenceId) {
        SousCompetence entity = sousCompetenceMapper.toEntity(dto);
        Competence competence = competenceService.getEntityById(competenceId);
        entity.setCompetence(competence);
        SousCompetence saved = sousCompetenceRepository.save(entity);
        return sousCompetenceMapper.toDTO(saved);
    }


    public SousCompetence updateValidation(Long id, boolean estValidee) {
        SousCompetence s = sousCompetenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sous-comp non trouvée"));
        s.setEstValidee(estValidee);
        return sousCompetenceRepository.save(s);
    }

    public List<SousCompetenceDTO> getAllSousCompetences() {
        return sousCompetenceRepository.findAll()
                .stream()
                .map(sousCompetenceMapper::toDTO)
                .toList();
    }

}
