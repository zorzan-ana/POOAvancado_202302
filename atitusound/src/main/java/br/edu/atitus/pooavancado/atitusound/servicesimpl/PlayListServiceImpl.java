package br.edu.atitus.pooavancado.atitusound.servicesimpl;

import org.springframework.stereotype.Service;

import br.edu.atitus.pooavancado.atitusound.entities.PlayListEntity;
import br.edu.atitus.pooavancado.atitusound.repositories.GenericRepository;
import br.edu.atitus.pooavancado.atitusound.repositories.PlayListRepository;
import br.edu.atitus.pooavancado.atitusound.services.PlayListService;

@Service
public class PlayListServiceImpl implements PlayListService{

	private PlayListRepository playListRepository;
	
	public PlayListServiceImpl(PlayListRepository playListRepository) {
		super();
		this.playListRepository = playListRepository;
	}

	@Override
	public GenericRepository<PlayListEntity> getRepository() {
		return playListRepository;
	}

}
