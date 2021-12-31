package br.com.joao.justasimplerpgtable.Jogador;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import org.springframework.beans.factory.annotation.Autowired;
import br.com.joao.justasimplerpgtable.model.entity.JogadorEntity;
import br.com.joao.justasimplerpgtable.model.entity.PersonagemEntity;
import br.com.joao.justasimplerpgtable.model.repository.JogadorRepo;


@DataJpaTest
public class JogadorServiceTest {
    
    @Autowired
    private JogadorRepo jogadorRepo;

    @AfterEach
    void afterEach(){
        jogadorRepo.deleteAll();
    }

    @Test
    void deveBoscarUmJogadorporNome(){
        //given
        JogadorEntity jogador = new JogadorEntity(
            "e",
            "e",
            new ArrayList<PersonagemEntity>(),
            true);
            jogadorRepo.save(jogador);

        //when
        List<JogadorEntity> jogadorEntityDB = jogadorRepo.findJogadorEntityByAtivoTrueAndNomeContaining("e");

        //then
        assertFalse(jogadorEntityDB.isEmpty());
    }

    @Test
    void deveBoscarUmJogadorporNomeEDarErro(){
        //when
        List<JogadorEntity> jogadorEntityDB = jogadorRepo.findJogadorEntityByAtivoTrueAndNomeContaining ("e");

        //then
        assertTrue(jogadorEntityDB.isEmpty());
    }

}
