package com.gestioncompetences.competence_tracker.mapper;

import com.gestioncompetences.competence_tracker.dto.CompetenceDTO;
import com.gestioncompetences.competence_tracker.entities.Competence;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CompetenceMapper {
    CompetenceDTO toDTO(Competence competence);
    Competence toEntity(CompetenceDTO dto);
}
