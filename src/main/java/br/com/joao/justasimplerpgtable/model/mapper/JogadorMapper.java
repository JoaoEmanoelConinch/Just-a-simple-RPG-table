/**
 * 
 */
package br.com.joao.justasimplerpgtable.model.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.joao.justasimplerpgtable.model.dto.JogadorDtoCadastro;
import br.com.joao.justasimplerpgtable.model.dto.JogadorDtoPadrao;
import br.com.joao.justasimplerpgtable.model.entity.JogadorEntity;

/**
 * @author JoaoEmanoelConinch
 *
 */
@Service
public class JogadorMapper {

	public JogadorEntity toEnatityByCadastro(JogadorDtoCadastro jogadorDtoCadastro) {
		JogadorEntity jogadorEntity = new JogadorEntity();
		jogadorEntity.setNome(jogadorDtoCadastro.nome);
		jogadorEntity.setSenha(jogadorDtoCadastro.senha);
		return jogadorEntity;
	}
	
	public JogadorDtoCadastro toDtoCadastro(JogadorEntity jogadorEntity) {
		JogadorDtoCadastro jogadorDtoCadastro = new JogadorDtoCadastro();
		jogadorDtoCadastro.nome=jogadorEntity.getNome();
		jogadorDtoCadastro.senha=jogadorEntity.getSenha();
		return jogadorDtoCadastro;
	}
	
	public JogadorEntity toEnatityByPadrao(JogadorDtoPadrao jogadorDtoPadrao) {
		JogadorEntity jogadorEntity = new JogadorEntity();
		jogadorEntity.setNome(jogadorDtoPadrao.nome);
		jogadorEntity.setSenha(jogadorDtoPadrao.senha);
		jogadorEntity.setAtivo(jogadorDtoPadrao.ativo);
		return jogadorEntity;
	}
	
	public JogadorDtoPadrao toDtoPadrao(JogadorEntity jogadorEntity) {
		JogadorDtoPadrao jogadorDtoPadrao = new JogadorDtoPadrao();
		jogadorDtoPadrao.nome=jogadorEntity.getNome();
		jogadorDtoPadrao.senha=jogadorEntity.getSenha();
		jogadorDtoPadrao.ativo=jogadorEntity.getAtivo();
		return jogadorDtoPadrao;
	}

	public List<JogadorDtoPadrao> toDtoPadraoList(List<JogadorEntity> jogadorEntities) {
		ArrayList<JogadorDtoPadrao> dtoPadroes = new ArrayList<JogadorDtoPadrao>();
		for (JogadorEntity jogadorEntity : jogadorEntities) {
			dtoPadroes.add(this.toDtoPadrao(jogadorEntity));
		}
		return dtoPadroes;
	}

}
