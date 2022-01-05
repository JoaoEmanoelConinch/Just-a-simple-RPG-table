package br.com.joao.justasimplerpgtable.model.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.joao.justasimplerpgtable.model.enumeratiom.Clase;
import br.com.joao.justasimplerpgtable.model.enumeratiom.Genero;

@Entity(name = "Personagem")
public class PersonagemEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_personagem")
	private Long id;
	
	@Column(name = "nome_personagem", nullable = false, columnDefinition = "text")
	private String nome;
	
	@Column(name = "apeligo_personagem", nullable = false, columnDefinition = "text")
	private String apelido;
	
	@Column(name = "genero_personagem", nullable = false)
	private Genero genero;
	
	@Column(name = "ataque_personagem", nullable = false)
	private Integer ataque;
	
	@Column(name = "defesa_personagem", nullable = false)
	private Integer defesa;
	
	@Column(name = "agilidade_personagem", nullable = false)
	private Integer agilidade;
	
	@Column(name = "hp_personagem", nullable = false)
	private Integer hp;
	
	@Column(name = "mp_personagem", nullable = false)
	private Integer mp;
	
	@Column(name = "classe_personagem", nullable = false)
	private Clase clase;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_jogador")
	@JsonIgnore
	private JogadorEntity jogador;
	
	//itens
	
	public PersonagemEntity() {}
	
	public PersonagemEntity(Long id, String nome, String apelido, Genero genero, Integer ataque, Integer defesa, Integer agilidade, Integer hp, Integer mp, Clase clase){
		this(nome, apelido, genero, ataque, defesa, agilidade, hp, mp, clase);
		this.setId(id);
		
	}
	
	public PersonagemEntity(String nome, String apelido, Genero genero, Integer ataque, Integer defesa, Integer agilidade, Integer hp, Integer mp, Clase clase){
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
	public Integer getAtaque() {
		return ataque;
	}
	/**
	 * @param ataque the ataque to set
	 */
	public void setAtaque(Integer ataque) {
		this.ataque = ataque;
	}
	/**
	 * @return the defesa
	 */
	public Integer getDefesa() {
		return defesa;
	}
	/**
	 * @param defesa the defesa to set
	 */
	public void setDefesa(Integer defesa) {
		this.defesa = defesa;
	}
	/**
	 * @return the agilidade
	 */
	public Integer getAgilidade() {
		return agilidade;
	}
	/**
	 * @param agilidade the agilidade to set
	 */
	public void setAgilidade(Integer agilidade) {
		this.agilidade = agilidade;
	}
	/**
	 * @return the hp
	 */
	public Integer getHp() {
		return hp;
	}
	/**
	 * @param hp the hp to set
	 */
	public void setHp(Integer hp) {
		this.hp = hp;
	}
	/**
	 * @return the mp
	 */
	public Integer getMp() {
		return mp;
	}
	/**
	 * @param mp the mp to set
	 */
	public void setMp(Integer mp) {
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
	
	public void setJogador(JogadorEntity jogador) {
		this.jogador = jogador;
	}
	public JogadorEntity getJogador() {
		return jogador;
	}
}
