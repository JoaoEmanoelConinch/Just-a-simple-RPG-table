package br.com.joao.justasimplerpgtable.controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.joao.justasimplerpgtable.model.Tokens;
import br.com.joao.justasimplerpgtable.model.dto.JogadorDtoCadastro;
import br.com.joao.justasimplerpgtable.model.entity.JogadorEntity;
import br.com.joao.justasimplerpgtable.model.exceptiom.LoginExceptiom;
import br.com.joao.justasimplerpgtable.model.service.JogadorService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private JogadorService jogadorService;
	
	@PostMapping
	public ResponseEntity<String> login(@RequestBody JogadorDtoCadastro jogadorDtoCadastro){
		JogadorEntity jogador = jogadorService.getByNameAndPassword(jogadorDtoCadastro.nome, jogadorDtoCadastro.senha);
		String token = UUID.randomUUID().toString();
		Tokens.tokens.add(token);
		return ResponseEntity.ok().body(token);
	}
	
}
