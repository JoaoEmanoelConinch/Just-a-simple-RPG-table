package br.com.joao.justasimplerpgtable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.joao.justasimplerpgtable.model.dto.PersonagemDtoPadrao;
import br.com.joao.justasimplerpgtable.model.entity.PersonagemEntity;
import br.com.joao.justasimplerpgtable.model.mapper.PersonagemMapper;
import br.com.joao.justasimplerpgtable.model.service.PersonagemService;

@RestController
@RequestMapping("/Personagem")
public class PersonagemController {

	@Autowired
	private PersonagemService personagemService;
	
	@Autowired
	private PersonagemMapper personagemMapper;
	
	@PostMapping
	public ResponseEntity<PersonagemDtoPadrao> post(@RequestBody PersonagemDtoPadrao personagemDtoPadrao){
		PersonagemEntity personagemEntity = personagemMapper.toEntityByPedrao(personagemDtoPadrao);
		PersonagemDtoPadrao dtoPadrao = personagemMapper.toDtoPadrao(personagemService.save(personagemEntity));
		return ResponseEntity.ok().body(dtoPadrao);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<PersonagemDtoPadrao> getById(@PathVariable("id") Long id){
		PersonagemEntity entity = personagemService.getById(id);
		return ResponseEntity.ok().body(personagemMapper.toDtoPadrao(entity));
	}
	
	@GetMapping("/find/all")
	public ResponseEntity<List<PersonagemDtoPadrao>> getAll(){
		List<PersonagemEntity> personagemEntities = personagemService.getAll();
		List<PersonagemDtoPadrao> dtoPadroes = personagemMapper.toDtoPedraoList(personagemEntities);
		return ResponseEntity.ok().body(dtoPadroes);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<PersonagemDtoPadrao> put(@PathVariable("id") Long id, @RequestBody PersonagemDtoPadrao dtoPadrao){
		PersonagemEntity entity = personagemMapper.toEntityByPedrao(dtoPadrao);
		PersonagemDtoPadrao padrao = personagemMapper.toDtoPadrao(personagemService.put(id, entity));
		return ResponseEntity.ok().body(padrao);
	}
	
	@DeleteMapping("/delete?{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id){
		personagemService.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
