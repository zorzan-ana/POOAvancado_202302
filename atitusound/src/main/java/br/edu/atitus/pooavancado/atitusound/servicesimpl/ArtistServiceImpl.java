package br.edu.atitus.pooavancado.atitusound.servicesimpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

	protected void validate(ArtistEntity entidade) throws Exception {
		if (entidade.getName() == null || entidade.getName().isEmpty())
			throw new Exception("É necessário informar um nome válido!");
		if (entidade.getUuid() == null) {
			if (artistRepository.existsByName(entidade.getName()))
				throw new Exception("Já existe um registro com este nome!");
		} else {
			if (!artistRepository.existsById(entidade.getUuid()))
				throw new Exception("Não existe registro com este UUID");
			if (artistRepository.existsByNameAndUuidNot(entidade.getName(), entidade.getUuid()))
				throw new Exception("Já existe um registro com este nome!");
		}
	}

	@Override
	public ArtistEntity save(ArtistEntity entidade) throws Exception {
		validate(entidade);
		return artistRepository.save(entidade);
	}

	@Override
	public List<ArtistEntity> findAll() throws Exception {
		return artistRepository.findAll();
	}

	@Override
	public Optional<ArtistEntity> findById(UUID uuid) throws Exception {
		return artistRepository.findById(uuid);
	}

	@Override
	public void deleteById(UUID uuid) throws Exception {
		if (!artistRepository.existsById(uuid))
			throw new Exception("Não existe registro com este UUID");
		artistRepository.deleteById(uuid);
	}

	@Override
	public Page<List<ArtistEntity>> findByNameContainingIgnoreCase(Pageable pageable, String name) throws Exception {
		return artistRepository.findByNameContainingIgnoreCase(pageable, name);
	}

}
