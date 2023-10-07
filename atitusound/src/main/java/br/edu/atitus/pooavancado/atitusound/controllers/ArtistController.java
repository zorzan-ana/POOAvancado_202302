package br.edu.atitus.pooavancado.atitusound.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.pooavancado.atitusound.entities.ArtistEntity;
import br.edu.atitus.pooavancado.atitusound.entities.dtos.ArtistDTO;
import br.edu.atitus.pooavancado.atitusound.repositories.ArtistRepository;

@RestController
@RequestMapping("/artists")
public class ArtistController {
	
	//Spring, Injeção de Dependências
	//Aqui o Spring Framework é responsável pela implementação, 
	//instanciação e injeção dentro do objeto ArtistController
	
	//@Autowired >> Spring recomenda utilizar métodos construtores
	
	private ArtistRepository artistRepository;
	
	public ArtistController(ArtistRepository artistRepository) {
		super();
		this.artistRepository = artistRepository;
	}
	
	protected ArtistEntity convertDTO2Entity(ArtistDTO dto) {
		ArtistEntity entidade = new ArtistEntity();
		entidade.setName(dto.getName());
		entidade.setImage(dto.getImage());
		return entidade;
	}
	
	@GetMapping("/{uuid}")
	public ResponseEntity<ArtistEntity> getByUuid(@PathVariable UUID uuid) {
		Optional<ArtistEntity> entidade = artistRepository.findById(uuid);
		if (entidade.isEmpty())
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(entidade.get());
	}
	
	@GetMapping
	public ResponseEntity<List<ArtistEntity>> getAll() {
		List<ArtistEntity> entidades = artistRepository.findAll();
		return ResponseEntity.ok(entidades);
	}

	@PostMapping
	public ResponseEntity<ArtistEntity> save(@RequestBody ArtistDTO dto) {
		ArtistEntity entidade = convertDTO2Entity(dto);
		artistRepository.save(entidade);
		return ResponseEntity.status(HttpStatus.CREATED).body(entidade);
	}

}
