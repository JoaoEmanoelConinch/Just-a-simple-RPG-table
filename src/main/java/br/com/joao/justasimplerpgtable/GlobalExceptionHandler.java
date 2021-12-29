package br.com.joao.justasimplerpgtable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({NullPointerException.class})
	public ResponseEntity<String> hendlerEx(Exception ex, WebRequest request){
		return new ResponseEntity<String>("Erro no sistema " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
