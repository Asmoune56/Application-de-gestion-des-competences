package com.gestioncompetences.competence_tracker.service;


import com.gestioncompetences.competence_tracker.Services.CompetenceService;
import com.gestioncompetences.competence_tracker.dto.CompetenceDTO;
import com.gestioncompetences.competence_tracker.entities.Competence;
import com.gestioncompetences.competence_tracker.mapper.CompetenceMapper;
import com.gestioncompetences.competence_tracker.repositories.CompetenceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CompetenceServiceTest {

    @Mock
    private CompetenceRepository competenceRepository;

    @Mock
    private CompetenceMapper competenceMapper;

    @InjectMocks
    private CompetenceService competenceService;

    @Test
    void testCreateCompetence() {
        // Arrange
        CompetenceDTO dto = new CompetenceDTO();
        dto.setNom("competence");

        Competence entity = new Competence();
        entity.setNom("competence");

        Competence savedEntity = new Competence();
        savedEntity.setId(1L);
        savedEntity.setNom("competence");

        CompetenceDTO savedDto = new CompetenceDTO();
        savedDto.setId(1L);
        savedDto.setNom("competence");

        when(competenceMapper.toEntity(dto)).thenReturn(entity);
        when(competenceRepository.save(entity)).thenReturn(savedEntity);
        when(competenceMapper.toDTO(savedEntity)).thenReturn(savedDto);


        CompetenceDTO result = competenceService.createCompetence(dto);


        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("competence", result.getNom());
    }


    @Test
    public void testGetCompetenceById() {
        // Arrange
        Long id = 1L;

        Competence savedEntity = new Competence();
        savedEntity.setId(id);
        savedEntity.setNom("Communication");

        CompetenceDTO savedDto = new CompetenceDTO();
        savedDto.setId(id);
        savedDto.setNom("Communication");

        when(competenceRepository.findById(id)).thenReturn(Optional.of(savedEntity));
        when(competenceMapper.toDTO(savedEntity)).thenReturn(savedDto);


        CompetenceDTO result = competenceService.getCompetenceById(id);


        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals("Communication", result.getNom());
    }



}
