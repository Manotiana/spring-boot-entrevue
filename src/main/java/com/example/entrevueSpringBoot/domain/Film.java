package com.example.entrevueSpringBoot.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="film")
public class Film {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String titre;
	
	private String description;
	
	//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToMany(targetEntity = Acteur.class, mappedBy="film",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Acteur> acteurs;
	
	
	public List<Acteur> getActeurs(){
		return acteurs;
	}
	
	 public void addActor(Acteur actor){
	        acteurs.add(actor);
	        actor.setFilm(this);
	    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
