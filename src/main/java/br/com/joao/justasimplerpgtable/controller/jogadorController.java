/**
 * 
 */
package br.com.joao.justasimplerpgtable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.joao.justasimplerpgtable.model.dto.JogadorDtoCadastro;
import br.com.joao.justasimplerpgtable.model.dto.JogadorDtoPadrao;
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
	
	@PostMapping
	public ResponseEntity<JogadorDtoPadrao> post(@RequestBody JogadorDtoCadastro jogadorDtoCadastro){
		return ResponseEntity.ok().body(jogadorService.save(jogadorDtoCadastro));
	}
	
}
