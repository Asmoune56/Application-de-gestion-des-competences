package com.gestioncompetences.competence_tracker.mapper;


import com.gestioncompetences.competence_tracker.dto.SousCompetenceDTO;
import com.gestioncompetences.competence_tracker.entities.SousCompetence;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SousCompetenceMapper {
    SousCompetenceDTO toDTO(SousCompetence sousCompetence);
    SousCompetence toEntity(SousCompetenceDTO dto);

}

