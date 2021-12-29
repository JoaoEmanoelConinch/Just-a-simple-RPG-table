package br.com.joao.justasimplerpgtable.model.dto;

import java.io.Serializable;

import br.com.joao.justasimplerpgtable.model.enumeratiom.Clase;
import br.com.joao.justasimplerpgtable.model.enumeratiom.Genero;

public class PersonagemDtoPadrao implements Serializable{
	
	public String nome;
	public String apelido;
	public Genero genero;
	public Short ataque;
	public Short defesa;
	public Short agilidade;
	public Short hp;
	public Short mp;
	public Clase clase;
}
