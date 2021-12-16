package br.com.joao.justasimplerpgtable.model;

import java.io.Serializable;

import br.com.joao.justasimplerpgtable.model.enumeration.StatusJogador;

public class JogadorEntity implements Serializable {

	private Long id;
	private String nome;
	private String senha;
	private StatusJogador status;
	
}
