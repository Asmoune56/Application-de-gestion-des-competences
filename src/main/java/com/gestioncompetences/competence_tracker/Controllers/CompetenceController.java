package com.gestioncompetences.competence_tracker.Controllers;

import com.gestioncompetences.competence_tracker.Services.CompetenceService;
import com.gestioncompetences.competence_tracker.entities.Competence;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competences")
@RequiredArgsConstructor
public class CompetenceController {

    private final CompetenceService competenceService;

    // 🔥 Ajouter une compétence
    @PostMapping
    public ResponseEntity<Competence> create(@RequestBody Competence competence) {
        return ResponseEntity.ok(competenceService.save(competence));
    }

    // 🔍 Lister toutes les compétences
    @GetMapping
    public ResponseEntity<List<Competence>> getAll() {
        return ResponseEntity.ok(competenceService.getAll());
    }

    // 📝 Modifier une compétence
    @PutMapping("/{id}")
    public ResponseEntity<Competence> update(@PathVariable Long id, @RequestBody Competence competence) {
        competence.setId(id);
        return ResponseEntity.ok(competenceService.save(competence));
    }

    // 🗑 Supprimer une compétence
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        competenceService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/export")
    public ResponseEntity<List<Competence>> export() {
        return ResponseEntity.ok(competenceService.getAll());
    }
}

