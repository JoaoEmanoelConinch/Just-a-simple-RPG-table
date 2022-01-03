/**
 * 
 */
package br.com.joao.justasimplerpgtable.model.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.joao.justasimplerpgtable.model.entity.JogadorEntity;

/**
 * @author JoaoEmanoelConinch
 *
 */
@Repository
public interface JogadorRepo extends JpaRepository<JogadorEntity, Long> {

	@Transactional
	Optional<JogadorEntity> findJogadorEntityByIdAndAtivoTrue(Long id);
	
	@Transactional
	List<JogadorEntity> findJogadorEntityByAtivoTrueAndNomeContaining(String nome);

	@Query("select case when count(jogador) > 0 then true else false end from JogadorEntity jogador wher jogador.nome = :nome")
    boolean nomeExiste(@Param("nome") String nome);

	@Query("select case when count(jogador) > 0 then true else false end from JogadorEntity jogador wher jogador.senha = :senha")
    boolean senhaExiste(@Param("senha") String senha);

}
