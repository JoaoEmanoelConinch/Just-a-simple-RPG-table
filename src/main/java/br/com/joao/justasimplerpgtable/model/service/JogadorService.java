package br.com.joao.justasimplerpgtable.model.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joao.justasimplerpgtable.model.entity.JogadorEntity;
import br.com.joao.justasimplerpgtable.model.exceptiom.JoagdorNaoEncontrado;
import br.com.joao.justasimplerpgtable.model.repository.JogadorRepo;

/**
 * @author JoaoEmanoelConinch
 *
 */
@Service
public class JogadorService implements Serializable {

	@Autowired
	private JogadorRepo jogadorRepo;

	public JogadorEntity save(JogadorEntity entity) {
		entity.setId(null);
		return jogadorRepo.save(entity);
	}

	public JogadorEntity getById(Long id) {
		return jogadorRepo.findJogadorEntityById(id)
				.orElseThrow(() -> new JoagdorNaoEncontrado("Joagdor com id = " + id + " nao encontrado"));
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

}
