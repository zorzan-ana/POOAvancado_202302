package br.edu.atitus.pooavancado.atitusound.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.pooavancado.atitusound.entities.ArtistEntity;
import br.edu.atitus.pooavancado.atitusound.entities.PlayListEntity;
import br.edu.atitus.pooavancado.atitusound.entities.dtos.ArtistDTO;
import br.edu.atitus.pooavancado.atitusound.entities.dtos.PlayListDTO;
import br.edu.atitus.pooavancado.atitusound.repositories.PlayListRepository;
import br.edu.atitus.pooavancado.atitusound.services.GenericService;
import br.edu.atitus.pooavancado.atitusound.services.PlayListService;

@RestController
@RequestMapping("/playlist")
public class PlayListController extends GenericController<PlayListEntity, PlayListDTO>{

	private PlayListService playListService;

	public PlayListController(PlayListService playListService) {
		super();
		this.playListService = playListService;
	}

	@Override
	GenericService<PlayListEntity> getService() {
		return playListService;
	}

	@Override
	PlayListEntity convertDTO2Entity(PlayListDTO dto) {
		PlayListEntity playList = new PlayListEntity();
		playList.setName(dto.getName());
		playList.setPublic_share(dto.getPublic_share());
		return playList;
	}

}
