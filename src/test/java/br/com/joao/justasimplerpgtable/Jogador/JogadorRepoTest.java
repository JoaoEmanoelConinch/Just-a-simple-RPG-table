package br.com.joao.justasimplerpgtable.Jogador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.joao.justasimplerpgtable.model.entity.JogadorEntity;
import br.com.joao.justasimplerpgtable.model.entity.PersonagemEntity;
import br.com.joao.justasimplerpgtable.model.repository.JogadorRepo;

@DataJpaTest
public class JogadorRepoTest {

    @Autowired
    private JogadorRepo jogadorRepo;

    @AfterEach
    void afterEach() {
        jogadorRepo.deleteAll();
    }

    @Test
    void deveRecuperarOJogadorPorId() {
        // given
        JogadorEntity jogador = new JogadorEntity(
                "a",
                "a",
                new ArrayList<PersonagemEntity>(),
                true);
        jogadorRepo.save(jogador);
        // wher
        Optional<JogadorEntity> newJogadorEntity = jogadorRepo.findJogadorEntityByIdAndAtivoTrue(jogador.getId());

        // then
        assertNotNull(newJogadorEntity.get());
    }

    @Test
    void naoDeveRecuperarOJogadorPorIdSeOJogadorEstiverInativo() {
        // given
        JogadorEntity jogador = new JogadorEntity(
                "e",
                "e",
                new ArrayList<PersonagemEntity>(),
                false);
        JogadorEntity jogadorEntity = jogadorRepo.save(jogador);
        // wher
        Optional<JogadorEntity> newJogadorEntity = jogadorRepo.findJogadorEntityByIdAndAtivoTrue(jogadorEntity.getId());

        // then
        assertTrue(newJogadorEntity.isEmpty());
    }

    @Test
    void deveBoscarUmJogadorporNome() {
        // given
        JogadorEntity jogador = new JogadorEntity(
                "e",
                "e",
                new ArrayList<PersonagemEntity>(),
                true);
        jogadorRepo.save(jogador);

        // when
        List<JogadorEntity> jogadorEntityDB = jogadorRepo.findJogadorEntityByAtivoTrueAndNomeContaining("e");

        // then
        assertFalse(jogadorEntityDB.isEmpty());
    }

    @Test
    void naoDeveBoscarUmJogadorporNomeSeEle() {
        // given
        JogadorEntity jogador = new JogadorEntity(
                "e",
                "e",
                new ArrayList<PersonagemEntity>(),
                false);
        jogadorRepo.save(jogador);

        // when
        List<JogadorEntity> jogadorEntityDB = jogadorRepo.findJogadorEntityByAtivoTrueAndNomeContaining("e");

        // then
        assertTrue(jogadorEntityDB.isEmpty());
    }

    @Test
    void deveBoscarUmJogadorporNomeEDarErro() {
        // when
        List<JogadorEntity> jogadorEntityDB = jogadorRepo.findJogadorEntityByAtivoTrueAndNomeContaining("e");

        // then
        assertTrue(jogadorEntityDB.isEmpty());
    }

    @Test
    void deveDizerSeONomeJaExiste() {
        // given
        JogadorEntity jogador = new JogadorEntity(
                "e",
                "e",
                new ArrayList<PersonagemEntity>(),
                false);
        jogadorRepo.save(jogador);

        // when
        Boolean nomeExiste = jogadorRepo.existsJogadorEntityByNome(jogador.getNome());

        // then
        assertTrue(nomeExiste);
    }

    @Test
    void naoDeveDizerSeONomeJaExiste() {
        // when
        Boolean nomeExiste = jogadorRepo.existsJogadorEntityByNome("e");

        // then
        assertFalse(nomeExiste);
    }

    @Test
    void deveDizerSeASenhaJaExiste() {
        // given
        JogadorEntity jogador = new JogadorEntity(
                "e",
                "e",
                new ArrayList<PersonagemEntity>(),
                false);
        jogadorRepo.save(jogador);

        // when
        Boolean nomeExiste = jogadorRepo.existsJogadorEntityBySenha(jogador.getSenha());

        // then
        assertTrue(nomeExiste);
    }

    @Test
    void naoDeveDizerSeASenhaJaExiste() {
        // when
        Boolean nomeExiste = jogadorRepo.existsJogadorEntityBySenha("e");

        // then
        assertFalse(nomeExiste);
    }

    @Test
    void deveRecuperarTodosOsJogadoresAtivos() {
        JogadorEntity jogador1 = new JogadorEntity(
                "e",
                "e",
                new ArrayList<PersonagemEntity>(),
                true);
        jogadorRepo.save(jogador1);

        JogadorEntity jogador2 = new JogadorEntity(
                "2",
                "e2",
                new ArrayList<PersonagemEntity>(),
                true);
        jogadorRepo.save(jogador2);

        JogadorEntity jogador3 = new JogadorEntity(
                "ee",
                "eqw",
                new ArrayList<PersonagemEntity>(),
                true);
        jogadorRepo.save(jogador3);

        List<JogadorEntity> jogadorEntities = jogadorRepo.findJogadorEntityByAtivoTrue();

        assertEquals(3, jogadorEntities.size());
    }

}
