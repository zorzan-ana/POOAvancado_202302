package br.edu.atitus.pooavancado.atitusound.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import br.edu.atitus.pooavancado.atitusound.entities.PlayListEntity;
import br.edu.atitus.pooavancado.atitusound.entities.UserEntity;

@Repository
public interface PlayListRepository extends GenericRepository<PlayListEntity>{
	
	Page<List<PlayListEntity>> findByNameContainingIgnoreCaseAndUserOrPublicshare(Pageable pageable, String name, UserEntity user, boolean publicshare);

}
