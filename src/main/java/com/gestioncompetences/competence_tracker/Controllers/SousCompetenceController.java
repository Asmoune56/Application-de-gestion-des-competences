package com.gestioncompetences.competence_tracker.Controllers;

import com.gestioncompetences.competence_tracker.Services.SousCompetenceService;
import com.gestioncompetences.competence_tracker.dto.SousCompetenceDTO;
import com.gestioncompetences.competence_tracker.mapper.SousCompetenceMapper;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@RestController
@RequestMapping("/api/souscompetences")
@RequiredArgsConstructor
public class SousCompetenceController {

    private final SousCompetenceService sousCompetenceService;
    private final SousCompetenceMapper sousCompetenceMapper;

    @PostMapping("/create/{competenceId}")
    public SousCompetenceDTO create(@RequestBody SousCompetenceDTO dto, @PathVariable Long competenceId) {
        return sousCompetenceService.create(dto, competenceId);
    }

    @PutMapping("/{id}/validation")
    public SousCompetenceDTO updateValidation(@PathVariable Long id, @RequestParam boolean estValidee) {
        return sousCompetenceMapper.toDTO(sousCompetenceService.updateValidation(id, estValidee));
    }

    @GetMapping("/export/pdf")
    public void exportPDF(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"sous_competences.pdf\"");

        List<SousCompetenceDTO> sousCompetences = sousCompetenceService.getAllSousCompetences();

        try (OutputStream out = response.getOutputStream()) {
            Document document = new Document();
            PdfWriter.getInstance(document, out);
            document.open();

            document.add(new Paragraph("Rapport des sous-compétences"));

            for (SousCompetenceDTO sc : sousCompetences) {
                document.add(new Paragraph(
                        sc.getId() + " - " + sc.getNom() + " : " + sc.getDescription()
                                + " (Validée: " + sc.isEstValidee() + ")"
                ));
            }

            document.close();
        } catch (DocumentException e) {
            throw new IOException(e);
        }
    }
}
