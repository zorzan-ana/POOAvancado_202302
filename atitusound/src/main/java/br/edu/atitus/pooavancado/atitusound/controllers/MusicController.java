package br.edu.atitus.pooavancado.atitusound.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.atitus.pooavancado.atitusound.entities.MusicEntity;
import br.edu.atitus.pooavancado.atitusound.entities.dtos.MusicDTO;
import br.edu.atitus.pooavancado.atitusound.services.GenericService;
import br.edu.atitus.pooavancado.atitusound.services.MusicService;

@RestController
@RequestMapping("/music")
public class MusicController extends GenericController<MusicEntity, MusicDTO>{

	private MusicService musicService;

	public MusicController(MusicService musicService) {
		super();
		this.musicService = musicService;
	}

	@Override
	GenericService<MusicEntity> getService() {
		return musicService;
	}

	@Override
	MusicEntity convertDTO2Entity(MusicDTO dto) {
		MusicEntity entidade = new MusicEntity();
		entidade.setDuration(dto.getDuration());
		entidade.setName(dto.getName());
		return entidade;
	}

	
}
