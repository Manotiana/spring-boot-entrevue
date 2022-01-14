package com.example.entrevueSpringBoot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entrevueSpringBoot.domain.Film;
import com.example.entrevueSpringBoot.dto.FilmDto;
import com.example.entrevueSpringBoot.mapper.FilmMapper;
import com.example.entrevueSpringBoot.responseStatus.NotFoundException;
import com.example.entrevueSpringBoot.service.FilmService;

@RestController
@RequestMapping("/api")
public class FilmController {

	@Autowired
	private FilmService filmService;
	
	
	@RequestMapping(value="/film/{id}", method=RequestMethod.GET)
	@ResponseBody
	public FilmDto getFilmById(@PathVariable(value = "id") Long id) {
	    Optional<Film> oFilm =  this.filmService.getFilmById(id);
	    if(!oFilm.isEmpty()) {
	    	FilmDto fDto = FilmMapper.INSTANCE.getFilmDto(oFilm.get());
		    return fDto;
	    }else {
	    	throw new NotFoundException();
	    }
	    
	}
	
	@RequestMapping(value ="/film", method = RequestMethod.POST)
	public Film createFilm(@RequestBody Film film) {
		return this.filmService.createFilm(film);
	}
}
