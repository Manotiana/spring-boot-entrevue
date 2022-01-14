package com.example.entrevueSpringBoot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.entrevueSpringBoot.domain.Film;
import com.example.entrevueSpringBoot.dto.FilmDto;

@Mapper
public interface FilmMapper {
    FilmMapper INSTANCE = Mappers.getMapper( FilmMapper.class );    
    FilmDto getFilmDto(Film film); 
}
