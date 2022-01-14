package com.example.entrevueSpringBoot.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entrevueSpringBoot.domain.Acteur;
import com.example.entrevueSpringBoot.domain.Film;
import com.example.entrevueSpringBoot.repository.ActeurRepository;
import com.example.entrevueSpringBoot.repository.FilmRepository;

@Service
public class FilmService {

	@Autowired
	private FilmRepository filmRepository;
	
	@Autowired
	private ActeurRepository acteurRepository;
	
	public Film createFilm(Film film) {
		for(Acteur a : film.getActeurs()) {
			a.setFilm(film);
		}
		return this.filmRepository.save(film);
	}
	
	public Optional<Film> getFilmById(Long id) {
		return this.filmRepository.findById(id);
	}
}
