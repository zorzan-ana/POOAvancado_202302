package br.edu.atitus.pooavancado.atitusound.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.pooavancado.atitusound.entities.ArtistEntity;
import br.edu.atitus.pooavancado.atitusound.repositories.ArtistRepository;

@RestController
@RequestMapping("/artists")
public class ArtistController {
	
	@Autowired
	private ArtistRepository artistRepository;
	
	@PostMapping
	public ResponseEntity<ArtistEntity> save(@RequestBody ArtistEntity artist) {
		artistRepository.save(artist);
		return ResponseEntity.status(HttpStatus.CREATED).body(artist);
	}

}
