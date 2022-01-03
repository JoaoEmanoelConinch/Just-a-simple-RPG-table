package br.com.joao.justasimplerpgtable.model.exceptiom;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FOUND, reason=" Essa senha já é usanda por outro jogador ")
public class SenhaExisteExcptiom extends RuntimeException{

    public SenhaExisteExcptiom(String msg) {
        super(msg);
    }

}
