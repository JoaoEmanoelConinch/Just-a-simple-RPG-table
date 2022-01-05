package br.com.joao.justasimplerpgtable.model.dto;

import java.io.Serializable;

import br.com.joao.justasimplerpgtable.model.enumeratiom.Clase;
import br.com.joao.justasimplerpgtable.model.enumeratiom.Genero;

public class PersonagemDtoPadrao implements Serializable{
	
	public String nome;
	public String apelido;
	public Genero genero;
	public Integer ataque;
	public Integer defesa;
	public Integer agilidade;
	public Integer hp;
	public Integer mp;
	public Clase clase;
}
