package br.com.joao.justasimplerpgtable.model.exceptiom;

import java.util.function.Supplier;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "O Jogador não existe")
public class JoagdorNaoEncontrado extends RuntimeException {

	public JoagdorNaoEncontrado(String msg) {
		super(msg);
	}

}
