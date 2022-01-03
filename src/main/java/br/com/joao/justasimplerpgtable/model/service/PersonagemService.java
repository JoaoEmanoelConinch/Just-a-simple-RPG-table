package br.com.joao.justasimplerpgtable.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.joao.justasimplerpgtable.model.entity.PersonagemEntity;
import br.com.joao.justasimplerpgtable.model.exceptiom.PersonagemNaoEncontrado;
import br.com.joao.justasimplerpgtable.model.repository.PersonagemRepo;

@Service
public class PersonagemService {

	private final PersonagemRepo perssonagemrepo;
	
	public PersonagemService(PersonagemRepo perssonagemrepo) {
		this.perssonagemrepo = perssonagemrepo;
	}

	public PersonagemEntity save(PersonagemEntity entity) {
		entity.setId(null);
		return perssonagemrepo.save(entity);
	}

	public PersonagemEntity getById(Long id) {
		return perssonagemrepo.findById(id)
				.orElseThrow(() -> new PersonagemNaoEncontrado("Personage com id = " + id + " nao encontrado"));
	}

	public List<PersonagemEntity> getAll() {
		return perssonagemrepo.findAll();
	}
	
	public PersonagemEntity put(Long id, PersonagemEntity entity) {
		entity.setId(id);
		return perssonagemrepo.save(entity);
	}
	
	public void delete(Long id) {
		perssonagemrepo.deleteById(id);
	}
	
}
