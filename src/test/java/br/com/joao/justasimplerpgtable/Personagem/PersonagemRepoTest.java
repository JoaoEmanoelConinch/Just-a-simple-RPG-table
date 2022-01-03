package br.com.joao.justasimplerpgtable.Personagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.joao.justasimplerpgtable.model.repository.PersonagemRepo;

@DataJpaTest
public class PersonagemRepoTest {
    
    @Autowired
    private PersonagemRepo personagemRepo;

    

}
