package br.com.joao.justasimplerpgtable.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.joao.justasimplerpgtable.model.entity.JogadorEntity;
import br.com.joao.justasimplerpgtable.model.entity.PersonagemEntity;
import br.com.joao.justasimplerpgtable.model.exceptiom.JogadorNaoEncontrado;
import br.com.joao.justasimplerpgtable.model.exceptiom.NomeExistsExcptiom;
import br.com.joao.justasimplerpgtable.model.exceptiom.SenhaExisteExcptiom;
import br.com.joao.justasimplerpgtable.model.repository.JogadorRepo;

/**
 * @author JoaoEmanoelConinch
 *
 */
@Service
public class JogadorService {

	
	private final JogadorRepo jogadorRepo;
	
	public JogadorService(JogadorRepo jogadorRepo, PersonagemService personagemService) {
		this.jogadorRepo = jogadorRepo;
		this.personagemService = personagemService;
	}

	private final PersonagemService personagemService;

	public JogadorEntity save(JogadorEntity entity) {
		entity.setId(null);
		entity.setPersonagens(new ArrayList<PersonagemEntity>());

		if(jogadorRepo.nomeExiste(entity.getNome())){
			throw new NomeExistsExcptiom(" Esse nome já é usando por outro jogador ");
		}
		if(jogadorRepo.senhaExiste(entity.getSenha())){
			throw new SenhaExisteExcptiom(" Essa senha já é usanda por outro jogador ");
		}
		
		return jogadorRepo.save(entity);
	}

	public JogadorEntity getById(Long id) {
		return jogadorRepo.findJogadorEntityByIdAndAtivoTrue(id)
				.orElseThrow(() -> new JogadorNaoEncontrado("Joagdor com id = " + id + " nao encontrado"));
	}

	public List<JogadorEntity> getAll() {
		return jogadorRepo.findAll();
	}

	public List<JogadorEntity> getAllByNome(String nome_jogador) {
		return jogadorRepo.findJogadorEntityByAtivoTrueAndNomeContaining(nome_jogador);
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
