package br.com.joao.justasimplerpgtable.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.joao.justasimplerpgtable.model.enumeration.StatusJogador;

/**
 * @author JoaoEmanoelConinch
 *
 */
@Entity
@Table
public class JogadorEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, unique = true)
	private String nome;

	@Column(nullable = false, unique = true)
	private String senha;

	@Enumerated(EnumType.STRING)
	private StatusJogador status;
	
	private boolean ativo = true;

//	@OneToMany
//	private List<Personagem> personagens;

	/**
	 * @param id
	 * @param nome
	 * @param senha
	 * @param status
	 * @param personagens
	 */
	public JogadorEntity(Long id, String nome, String senha, StatusJogador status/*, List<Personagem> personagens*/, Boolean ativo) {
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.status = status;
//		this.personagens = personagens;
		this.setAtivo(ativo);
	}

	public JogadorEntity() {
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
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return the status
	 */
	public StatusJogador getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(StatusJogador status) {
		this.status = status;
	}

//	/**
//	 * @return the personagens
//	 */
//	public List<Personagem> getPersonagens() {
//		return personagens;
//	}
//
//	/**
//	 * @param personagens the personagens to set
//	 */
//	public void setPersonagens(List<Personagem> personagens) {
//		this.personagens = personagens;
	
	/**
	 * @return the ativo
	 */
	public boolean getAtivo() {
		return ativo;
	}

	/**
	 * @param ativo the ativo to set
	 */
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "JogadorEntity [nome=" + nome + ", status=" + status + "]";
	}

}
