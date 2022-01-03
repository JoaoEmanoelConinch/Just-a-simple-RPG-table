package br.com.joao.justasimplerpgtable.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.joao.justasimplerpgtable.model.entity.PersonagemEntity;

@Repository
public interface PersonagemRepo extends JpaRepository<PersonagemEntity, Long>{

}
