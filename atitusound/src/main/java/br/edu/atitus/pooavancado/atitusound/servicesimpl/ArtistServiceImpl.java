package br.edu.atitus.pooavancado.atitusound.servicesimpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.edu.atitus.pooavancado.atitusound.entities.ArtistEntity;
import br.edu.atitus.pooavancado.atitusound.repositories.ArtistRepository;
import br.edu.atitus.pooavancado.atitusound.services.ArtistService;

@Service
public class ArtistServiceImpl implements ArtistService {
	
	private ArtistRepository artistRepository;
	
	public ArtistServiceImpl(ArtistRepository artistRepository) {
		super();
		this.artistRepository = artistRepository;
	}

	@Override
	public ArtistEntity save(ArtistEntity entidade) throws Exception {
		if (entidade.getName() == null || entidade.getName().isEmpty())
			throw new Exception("É necessário informar um nome válido!");
		
		return artistRepository.save(entidade);
	}

	@Override
	public List<ArtistEntity> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<ArtistEntity> findById(UUID uuid) throws Exception {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void deleteById(UUID uuid) throws Exception {
		// TODO Auto-generated method stub

	}

}
