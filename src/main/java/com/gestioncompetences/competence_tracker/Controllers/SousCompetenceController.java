package com.gestioncompetences.competence_tracker.Controllers;

import com.gestioncompetences.competence_tracker.Repositories.SousCompetenceRepository;
import com.gestioncompetences.competence_tracker.entities.SousCompetence;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sous-competences")
@RequiredArgsConstructor
public class SousCompetenceController {

    private final SousCompetenceRepository sousCompetenceRepository;

    @PutMapping("/{id}/status")
    public ResponseEntity<SousCompetence> updateStatus(@PathVariable Long id, @RequestParam boolean validee) {
        SousCompetence sc = sousCompetenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SousCompétence introuvable"));
        sc.setValidee(validee);
        sousCompetenceRepository.save(sc);
        return ResponseEntity.ok(sc);
    }
}

