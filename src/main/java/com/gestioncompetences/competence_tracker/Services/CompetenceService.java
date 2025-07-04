package com.gestioncompetences.competence_tracker.Services;

import com.gestioncompetences.competence_tracker.dto.CompetenceDTO;
import com.gestioncompetences.competence_tracker.mapper.CompetenceMapper;
import com.gestioncompetences.competence_tracker.repositories.CompetenceRepository;
import com.gestioncompetences.competence_tracker.entities.Competence;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Request;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CompetenceService {
    private final CompetenceRepository competenceRepository;
    private final CompetenceMapper competenceMapper;

public CompetenceDTO createCompetence( CompetenceDTO competenceDTO) {
    Competence c = competenceMapper.toEntity(competenceDTO);
    return competenceMapper.toDTO(competenceRepository.save(c));
}

    public CompetenceDTO getCompetenceById(Long id) {
        Competence competence = competenceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Competence not found"));
        return competenceMapper.toDTO(competence);
    }

    public Competence getEntityById(Long id) {
        return competenceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Compétence introuvable"));
    }




    public List<CompetenceDTO> getAllCompetences() {
    return competenceRepository.findAll().stream()
            .map(competenceMapper::toDTO).toList();
    }


   public CompetenceDTO updateCompetence(Long id ,CompetenceDTO competenceDTO) {
            Competence com = competenceRepository.findById(id).get();
            com.setNom(competenceDTO.getNom());
            return competenceMapper.toDTO(competenceRepository.save(com));

   }

    public void delete(Long id) {
        competenceRepository.deleteById(id);
    }
}

