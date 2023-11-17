package br.edu.atitus.pooavancado.atitusound.servicesimpl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.edu.atitus.pooavancado.atitusound.entities.UserEntity;
import br.edu.atitus.pooavancado.atitusound.repositories.GenericRepository;
import br.edu.atitus.pooavancado.atitusound.repositories.UserRepository;
import br.edu.atitus.pooavancado.atitusound.services.UserService;

@Service
public class UserServiceImpl implements UserService  {
	
	private final UserRepository repository;
	private final PasswordEncoder passwordEncoder;
	public UserServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder) {
		super();
		this.repository = repository;
		this.passwordEncoder = passwordEncoder;
	}


	@Override
	public GenericRepository<UserEntity> getRepository() {
		return repository;
	}


	@Override
	public void validate(UserEntity entidade) throws Exception {
		UserService.super.validate(entidade);
		if(entidade.getUsername() == null || entidade.getUsername().isEmpty())
			throw new Exception("Campo userName inválido!");
		if(entidade.getUuid() == null) {
			if(repository.existsByUsername(entidade.getUsername()))
				throw new Exception("Já exixte usuário com este userName!");
		}else {
			if(repository.existsByNameAndUuidNot(entidade.getUsername(), entidade.getUuid()))
				throw new Exception("Já exixte usuário com este userName!");
		}
		entidade.setPassword(passwordEncoder.encode(entidade.getPassword()));
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var user = repository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com esse Username"));
		return user;
	}
	
}
