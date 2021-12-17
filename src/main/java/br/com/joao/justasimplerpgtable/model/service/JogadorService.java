package br.com.joao.justasimplerpgtable.model.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joao.justasimplerpgtable.model.dto.JogadorDtoCadastro;
import br.com.joao.justasimplerpgtable.model.dto.JogadorDtoPadrao;
import br.com.joao.justasimplerpgtable.model.entity.JogadorEntity;
import br.com.joao.justasimplerpgtable.model.mapper.JogadorMapper;
import br.com.joao.justasimplerpgtable.model.repository.JogadorRepo;

/**
 * @author JoaoEmanoelConinch
 *
 */
@Service
public class JogadorService implements Serializable {

	@Autowired
	private JogadorRepo jogadorRepo;
	
	@Autowired
	private JogadorMapper jogadorMapper;
	
	public JogadorDtoPadrao save(JogadorDtoCadastro jogadorDtoCadastro) {
		JogadorEntity entity = jogadorMapper.toEnatityByCadastro(jogadorDtoCadastro);
		return jogadorMapper.toDtoPedrao(jogadorRepo.save(entity));
	}
	
}
