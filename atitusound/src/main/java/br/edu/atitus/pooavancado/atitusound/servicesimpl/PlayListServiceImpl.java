package br.edu.atitus.pooavancado.atitusound.servicesimpl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.edu.atitus.pooavancado.atitusound.entities.PlayListEntity;
import br.edu.atitus.pooavancado.atitusound.entities.UserEntity;
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

	@Override
	public void validate(PlayListEntity entidade) throws Exception {
		PlayListService.super.validate(entidade);
		UserEntity user = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		entidade.setUser(user);
	}

	@Override
	public Page<List<PlayListEntity>> findByNameContainingIgnoreCase(Pageable pageable, String name) throws Exception {
		
		UserEntity user = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return playListRepository.findByNameContainingIgnoreCaseAndUserOrPublicshare(pageable, name, user, true);
	}

}
