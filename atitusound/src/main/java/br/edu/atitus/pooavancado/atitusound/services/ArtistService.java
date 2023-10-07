package br.edu.atitus.pooavancado.atitusound.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.edu.atitus.pooavancado.atitusound.entities.ArtistEntity;

public interface ArtistService {
	
	ArtistEntity save(ArtistEntity entidade) throws Exception;
	
	List<ArtistEntity> findAll() throws Exception;
	
	Optional<ArtistEntity> findById(UUID uuid) throws Exception;
	
	void deleteById(UUID uuid) throws Exception;

}
