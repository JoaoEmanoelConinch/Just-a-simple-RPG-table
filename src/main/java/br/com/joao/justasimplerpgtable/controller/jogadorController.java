/**
 * 
 */
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

import br.com.joao.justasimplerpgtable.model.dto.JogadorDtoCadastro;
import br.com.joao.justasimplerpgtable.model.dto.JogadorDtoPadrao;
import br.com.joao.justasimplerpgtable.model.entity.JogadorEntity;
import br.com.joao.justasimplerpgtable.model.mapper.JogadorMapper;
import br.com.joao.justasimplerpgtable.model.service.JogadorService;

/**
 * @author rodrigo
 *
 */
@RestController
@RequestMapping("/Player")
public class jogadorController {

	@Autowired
	private JogadorService jogadorService;
	
	@Autowired
	private JogadorMapper jogadorMapper;
	
	@PostMapping
	public ResponseEntity<JogadorDtoPadrao> post(@RequestBody JogadorDtoCadastro jogadorDtoCadastro){
		JogadorEntity entity = jogadorMapper.toEnatityByCadastro(jogadorDtoCadastro);
		JogadorDtoPadrao jogadorDtoPadrao = jogadorMapper.toDtoPadrao(jogadorService.save(entity));
		return ResponseEntity.ok().body(jogadorDtoPadrao);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<JogadorDtoPadrao> getById(@PathVariable("id") Long id){
		JogadorEntity entity = jogadorService.getById(id);
		return ResponseEntity.ok().body(jogadorMapper.toDtoPadrao(entity));
	}
	
	@GetMapping("/find/all")
	public ResponseEntity<List<JogadorDtoPadrao>> getAll(){
		List<JogadorEntity> jogadorEntities = jogadorService.getAll();
		List<JogadorDtoPadrao> dtoPadroes = jogadorMapper.toDtoPadraoList(jogadorEntities);
		return ResponseEntity.ok().body(dtoPadroes);
	}

	@GetMapping("/find/name/{nome}")
	public ResponseEntity<List<JogadorDtoPadrao>> getAllByNome(@PathVariable("nome") String nome){
		List<JogadorEntity> jogadorEntities = jogadorService.getAllByNome(nome);
		List<JogadorDtoPadrao> dtoPadroes = jogadorMapper.toDtoPadraoList(jogadorEntities);
		return ResponseEntity.ok().body(dtoPadroes);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<JogadorDtoPadrao> put(@PathVariable("id") Long id, @RequestBody JogadorDtoPadrao jogadorDtoPadrao){
		JogadorEntity entity = jogadorMapper.toEnatityByPadrao(jogadorDtoPadrao);
		JogadorDtoPadrao dtoPadrao = jogadorMapper.toDtoPadrao(jogadorService.put(id, entity));
		return ResponseEntity.ok().body(dtoPadrao);
	}
	
	@DeleteMapping("/delete?{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id){
		jogadorService.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
