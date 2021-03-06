/**
 * 
 */
package br.com.joao.justasimplerpgtable.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.joao.justasimplerpgtable.model.entity.JogadorEntity;

/**
 * @author JoaoEmanoelConinch
 *
 */
@Repository
public interface JogadorRepo extends JpaRepository<JogadorEntity, Long> {

	Optional<JogadorEntity> findJogadorEntityById(Long id);

}
