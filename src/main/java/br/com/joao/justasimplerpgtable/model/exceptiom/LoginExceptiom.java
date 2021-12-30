package br.com.joao.justasimplerpgtable.model.exceptiom;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "nome ou senha errados")
public class LoginExceptiom extends RuntimeException {
	
	public LoginExceptiom(String msg) {
		super(msg);
	}

}
