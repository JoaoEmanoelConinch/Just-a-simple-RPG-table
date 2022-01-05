package br.com.joao.justasimplerpgtable.model.exceptiom;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FOUND, reason=" Esse nome já é usando por outro jogador ")
public class NomeExistsExcptiom extends RuntimeException{

    public NomeExistsExcptiom (String msg){
        super(msg);
    }

}
