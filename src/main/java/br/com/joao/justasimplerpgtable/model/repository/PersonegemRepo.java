package br.com.joao.justasimplerpgtable.model.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.joao.justasimplerpgtable.model.entity.PersonagemEntity;

@Repository
public interface PersonegemRepo extends JpaRepository<PersonagemEntity, Long>{

	@Transactional
	Optional<PersonagemEntity> findPersonagemEntityById(Long id);

}
