package com.gestioncompetences.competence_tracker.Controllers;


import com.gestioncompetences.competence_tracker.Services.CompetenceService;
import com.gestioncompetences.competence_tracker.dto.CompetenceDTO;
import com.gestioncompetences.competence_tracker.entities.Competence;
import com.gestioncompetences.competence_tracker.mapper.CompetenceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/competences")
@RequiredArgsConstructor
public class CompetenceController {
    private final CompetenceService competenceService;

    @PostMapping
    public CompetenceDTO createcompetence(@RequestBody CompetenceDTO competenceDTO) {
        return competenceService.createCompetence(competenceDTO);
    }

    @GetMapping
public List<CompetenceDTO> getAllCompetences() {
        return competenceService.getAllCompetences();
    }

    @GetMapping("/{id}")
    public CompetenceDTO getCompetenceById(@PathVariable Long id) {
        return competenceService.getCompetenceById(id);
    }
    @PutMapping("/{id}")
    public CompetenceDTO updateCompetence(@PathVariable Long id, @RequestBody CompetenceDTO competenceDTO) {
        return competenceService.updateCompetence(id, competenceDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        competenceService.delete(id);
    }
}
