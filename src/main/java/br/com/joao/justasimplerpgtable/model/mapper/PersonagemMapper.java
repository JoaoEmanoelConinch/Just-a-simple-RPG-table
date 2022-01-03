package br.com.joao.justasimplerpgtable.model.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.joao.justasimplerpgtable.model.dto.PersonagemDtoPadrao;
import br.com.joao.justasimplerpgtable.model.entity.PersonagemEntity;

@Service
public class PersonagemMapper {

	public PersonagemDtoPadrao toDtoPadrao (PersonagemEntity entity) {
		PersonagemDtoPadrao dto = new PersonagemDtoPadrao();
		dto.nome = entity.getNome();
		dto.apelido = entity.getApelido();
		dto.ataque = entity.getAtaque();
		dto.agilidade = entity.getAgilidade();
		dto.defesa = entity.getDefesa();
		dto.genero = entity.getGenero();
		dto.mp = entity.getMp();
		dto.hp = entity.getHp();
		dto.clase = entity.getClase();
		return dto;
	}
	
	public PersonagemEntity toEntityByPedrao(PersonagemDtoPadrao dto) {
		PersonagemEntity entity = new PersonagemEntity();
		entity.setNome(dto.nome);
		entity.setApelido(dto.apelido);
		entity.setGenero(dto.genero);
		entity.setClase(dto.clase);
		entity.setDefesa(dto.defesa);
		entity.setAgilidade(dto.agilidade);
		entity.setAtaque(dto.ataque);
		entity.setHp(dto.hp);
		entity.setMp(dto.mp);
		return entity;
	}
	
	public List<PersonagemDtoPadrao> toDtoPedraoList(List<PersonagemEntity> entities){
		ArrayList<PersonagemDtoPadrao> dtoPadroes = new ArrayList<PersonagemDtoPadrao>();
		for(PersonagemEntity personagemEntity: entities) {
			dtoPadroes.add(this.toDtoPadrao(personagemEntity));
		}
		return dtoPadroes;
	}
	
}
