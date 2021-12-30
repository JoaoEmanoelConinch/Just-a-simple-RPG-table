package br.com.joao.justasimplerpgtable.model.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joao.justasimplerpgtable.model.entity.JogadorEntity;
import br.com.joao.justasimplerpgtable.model.entity.PersonagemEntity;
import br.com.joao.justasimplerpgtable.model.exceptiom.JogadorNaoEncontrado;
import br.com.joao.justasimplerpgtable.model.repository.JogadorRepo;

/**
 * @author JoaoEmanoelConinch
 *
 */
@Service
public class JogadorService {

	@Autowired
	private JogadorRepo jogadorRepo;
	
	@Autowired
	private PersonagemService personagemService;

	public JogadorEntity save(JogadorEntity entity) {
		entity.setId(null);
		return jogadorRepo.save(entity);
	}

	public JogadorEntity getById(Long id) {
		return jogadorRepo.findJogadorEntityById(id)
				.orElseThrow(() -> new JogadorNaoEncontrado("Joagdor com id = " + id + " nao encontrado"));
	}

	public List<JogadorEntity> getAll() {
		return jogadorRepo.findAll();
	}
	
	public JogadorEntity put(Long id, JogadorEntity jogadorEntity) {
		jogadorEntity.setId(id);
		return jogadorRepo.save(jogadorEntity);
	}
	
	public void delete(Long id) {
		JogadorEntity jogadorEntity = getById(id);
		jogadorEntity.setAtivo(false);
		jogadorRepo.save(jogadorEntity);
	}
	
	public void AtribuirPersonagemAUmJogador (Long idPersonagem, Long idJogador) {
		PersonagemEntity personagemEntity = personagemService.getById(idPersonagem);
		JogadorEntity jogadorEntity = this.getById(idJogador);
		
		personagemEntity.setJogador(jogadorEntity);
		personagemService.put(idPersonagem, personagemEntity);
		
		jogadorEntity.getPersonagens().add(personagemEntity);
		this.put(idJogador, jogadorEntity);
	}

}
