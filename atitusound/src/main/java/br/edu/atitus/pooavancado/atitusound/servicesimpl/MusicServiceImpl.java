package br.edu.atitus.pooavancado.atitusound.servicesimpl;

import org.springframework.stereotype.Service;

import br.edu.atitus.pooavancado.atitusound.entities.MusicEntity;
import br.edu.atitus.pooavancado.atitusound.repositories.GenericRepository;
import br.edu.atitus.pooavancado.atitusound.repositories.MusicRepository;
import br.edu.atitus.pooavancado.atitusound.services.MusicService;

@Service
public class MusicServiceImpl implements MusicService {
	
	private MusicRepository musicRepository;


	public MusicServiceImpl(MusicRepository musicRepository) {
		super();
		this.musicRepository = musicRepository;
	}

	@Override
	public GenericRepository<MusicEntity> getRepository() {
		return musicRepository;
	}

}
