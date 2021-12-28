package br.com.joao.justasimplerpgtable.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.joao.justasimplerpgtable.model.enumeratiom.Clase;
import br.com.joao.justasimplerpgtable.model.enumeratiom.Genero;

@Entity(name = "Personagem")
public class PersonagemEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(nullable = false, columnDefinition = "text")
	private String nome;
	
	@Column(nullable = false, columnDefinition = "text")
	private String apelido;
	
	@Column(nullable = false)
	private Genero genero;
	
	@Column(nullable = false)
	private Short ataque;
	
	@Column(nullable = false)
	private Short defesa;
	
	@Column(nullable = false)
	private Short agilidade;
	
	@Column(nullable = false)
	private Short hp;
	
	@Column(nullable = false)
	private Short mp;
	
	@Column(nullable = false)
	private Clase clase;
	
	//itens
	
	public PersonagemEntity() {}
	
	public PersonagemEntity(Long id, String nome, String apelido, Genero genero, Short ataque, Short defesa, Short agilidade, Short hp, Short mp, Clase clase){
		this.setId(id);
		this.setNome(nome);
		this.setApelido(apelido);
		this.setGenero(genero);
		this.setAtaque(ataque);
		this.setDefesa(defesa);
		this.setAgilidade(agilidade);
		this.setHp(hp);
		this.setMp(mp);
		this.setClase(clase);
	}
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the apelido
	 */
	public String getApelido() {
		return apelido;
	}
	/**
	 * @param apelido the apelido to set
	 */
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	/**
	 * @return the genero
	 */
	public Genero getGenero() {
		return genero;
	}
	/**
	 * @param genero the genero to set
	 */
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	/**
	 * @return the ataque
	 */
	public Short getAtaque() {
		return ataque;
	}
	/**
	 * @param ataque the ataque to set
	 */
	public void setAtaque(Short ataque) {
		this.ataque = ataque;
	}
	/**
	 * @return the defesa
	 */
	public Short getDefesa() {
		return defesa;
	}
	/**
	 * @param defesa the defesa to set
	 */
	public void setDefesa(Short defesa) {
		this.defesa = defesa;
	}
	/**
	 * @return the agilidade
	 */
	public Short getAgilidade() {
		return agilidade;
	}
	/**
	 * @param agilidade the agilidade to set
	 */
	public void setAgilidade(Short agilidade) {
		this.agilidade = agilidade;
	}
	/**
	 * @return the hp
	 */
	public Short getHp() {
		return hp;
	}
	/**
	 * @param hp the hp to set
	 */
	public void setHp(Short hp) {
		this.hp = hp;
	}
	/**
	 * @return the mp
	 */
	public Short getMp() {
		return mp;
	}
	/**
	 * @param mp the mp to set
	 */
	public void setMp(Short mp) {
		this.mp = mp;
	}
	/**
	 * @return the clase
	 */
	public Clase getClase() {
		return clase;
	}
	/**
	 * @param clase the clase to set
	 */
	public void setClase(Clase clase) {
		this.clase = clase;
	}
}
