package br.com.joao.justasimplerpgtable.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mapping.context.PersistentEntities;
import org.springframework.stereotype.Service;

import br.com.joao.justasimplerpgtable.model.entity.JogadorEntity;
import br.com.joao.justasimplerpgtable.model.entity.PersonagemEntity;
import br.com.joao.justasimplerpgtable.model.exceptiom.PersonagemNaoEncontrado;
import br.com.joao.justasimplerpgtable.model.repository.PersonegemRepo;

@Service
public class PersonagemService {

	private final PersonegemRepo perssonegemrepo;
	
	public PersonagemService(PersonegemRepo perssonegemrepo) {
		this.perssonegemrepo = perssonegemrepo;
	}

	public PersonagemEntity save(PersonagemEntity entity) {
		entity.setId(null);
		return perssonegemrepo.save(entity);
	}

	public PersonagemEntity getById(Long id) {
		return perssonegemrepo.findPersonagemEntityById(id)
				.orElseThrow(() -> new PersonagemNaoEncontrado("Personage com id = " + id + " nao encontrado"));
	}

	public List<PersonagemEntity> getAll() {
		return perssonegemrepo.findAll();
	}
	
	public PersonagemEntity put(Long id, PersonagemEntity entity) {
		entity.setId(id);
		return perssonegemrepo.save(entity);
	}
	
	public void delete(Long id) {
		perssonegemrepo.deleteById(id);
	}
	
}
