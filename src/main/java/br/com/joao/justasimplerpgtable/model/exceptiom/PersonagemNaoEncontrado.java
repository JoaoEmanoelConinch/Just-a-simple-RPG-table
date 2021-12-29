package br.com.joao.justasimplerpgtable.model.exceptiom;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "personagem não encontrado")
public class PersonagemNaoEncontrado extends RuntimeException {

	public PersonagemNaoEncontrado (String msg) {
		super(msg);
	}
	
}
