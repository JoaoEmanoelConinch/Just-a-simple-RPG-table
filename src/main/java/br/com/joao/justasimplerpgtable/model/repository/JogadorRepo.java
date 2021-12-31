/**
 * 
 */
package br.com.joao.justasimplerpgtable.model.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
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

}
