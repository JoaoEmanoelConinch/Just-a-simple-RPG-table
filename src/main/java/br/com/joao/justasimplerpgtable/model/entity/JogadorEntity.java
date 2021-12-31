package br.com.joao.justasimplerpgtable.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.joao.justasimplerpgtable.model.enumeratiom.StatusJogador;

/**
 * @author JoaoEmanoelConinch
 *
 */
@Entity(name = "jogador")
@Table(name = "jogador")
public class JogadorEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_jogador")
	private Long id;

	@Column(name = "nome_jogador", nullable = false, unique = true)
	private String nome;

	@Column(name = "senha_jogador", nullable = false, unique = true)
	private String senha;

	@Column(name = "is_ativo_jogador")
	private boolean ativo = true;

	@OneToMany(mappedBy = "jogador", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PersonagemEntity> personagens;

	/**
	 * @param id
	 * @param nome
	 * @param senha
	 * @param status
	 * @param personagens
	 */
	public JogadorEntity(Long id, String nome, String senha, List<PersonagemEntity> personagens, Boolean ativo) {
		this(nome,senha,personagens,ativo);
		this.setId(id);
	}

	public JogadorEntity(String nome, String senha, List<PersonagemEntity> personagens,
			Boolean ativo) {
		this.setNome(nome);
		this.setSenha(senha);
		this.setPersonagens(personagens);
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
	 * @return the personagens
	 */
	public List<PersonagemEntity> getPersonagens() {
		return personagens;
	}

	/**
	 * @param personagens the personagens to set
	 */
	public void setPersonagens(List<PersonagemEntity> personagens) {
		this.personagens = personagens;
	}
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
		return "JogadorEntity [nome=" + nome +"]";
	}

}
