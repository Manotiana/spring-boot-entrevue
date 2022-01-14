package com.example.entrevueSpringBoot.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.entrevueSpringBoot.domain.Acteur;
import com.example.entrevueSpringBoot.dto.ActeurDto;

@Mapper
public interface ActeurMapper {
	    ActeurMapper INSTANCE = Mappers.getMapper( ActeurMapper.class );    
	    ActeurDto getActeurDto(Acteur acteur); 
	    List<ActeurDto> mapActeurs (List<Acteur> acteurs);
}
