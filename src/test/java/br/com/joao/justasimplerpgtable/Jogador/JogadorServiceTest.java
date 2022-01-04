package br.com.joao.justasimplerpgtable.Jogador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.joao.justasimplerpgtable.model.entity.JogadorEntity;
import br.com.joao.justasimplerpgtable.model.entity.PersonagemEntity;
import br.com.joao.justasimplerpgtable.model.enumeratiom.Clase;
import br.com.joao.justasimplerpgtable.model.enumeratiom.Genero;
import br.com.joao.justasimplerpgtable.model.repository.JogadorRepo;
import br.com.joao.justasimplerpgtable.model.service.JogadorService;
import br.com.joao.justasimplerpgtable.model.service.PersonagemService;
import br.com.joao.justasimplerpgtable.model.exceptiom.NomeExistsExcptiom;
import br.com.joao.justasimplerpgtable.model.exceptiom.SenhaExisteExcptiom;
import br.com.joao.justasimplerpgtable.model.exceptiom.JogadorNaoEncontrado;

@DataJpaTest
public class JogadorServiceTest {

    @Mock
    private JogadorRepo jogadorRepo;

    @Mock
    private PersonagemService personagemService;
    private AutoCloseable autoCloseable;

    private JogadorService jogadorService;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        jogadorService = new JogadorService(jogadorRepo, personagemService);
    }

    @AfterEach
    void TearDow() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAll() {
        // when
        jogadorService.getAll();

        // then
        verify(jogadorRepo).findJogadorEntityByAtivoTrue();
    }

    @Test
    void canAddJogador() {
        JogadorEntity jogador = new JogadorEntity(
                "e",
                "e",
                new ArrayList<PersonagemEntity>(),
                true);
        jogadorService.save(jogador);

        ArgumentCaptor<JogadorEntity> argumentCaptor = ArgumentCaptor.forClass(JogadorEntity.class);

        verify(jogadorRepo).save(argumentCaptor.capture());

        JogadorEntity jogadorArgment = argumentCaptor.getValue();

        assertEquals(jogador, jogadorArgment);

    }

    @Test
    void canNotAddJogadorCouseNomeExistis() {
        JogadorEntity jogador = new JogadorEntity(
                "e",
                "e",
                new ArrayList<PersonagemEntity>(),
                true);

        given(jogadorRepo.existsJogadorEntityByNome(anyString())).willReturn(true);

        assertThrows(NomeExistsExcptiom.class, () -> {
            jogadorService.save(jogador);
        });
        verify(jogadorRepo, never()).save(any());
    }

    @Test
    void canNotAddJogadorCouseSenhaExistis() {
        JogadorEntity jogador = new JogadorEntity(
                "e",
                "e",
                new ArrayList<PersonagemEntity>(),
                true);

        given(jogadorRepo.existsJogadorEntityBySenha(anyString())).willReturn(true);

        assertThrows(SenhaExisteExcptiom.class, () -> {
            jogadorService.save(jogador);
        });
        verify(jogadorRepo, never()).save(any());
    }

    @Test
    void canGetAJogaorById() {
        JogadorEntity jogador = new JogadorEntity(
                1l,
                "e",
                "e",
                new ArrayList<PersonagemEntity>(),
                true);

        when(jogadorRepo.findJogadorEntityByIdAndAtivoTrue(jogador.getId())).thenReturn(Optional.of(jogador));

        JogadorEntity expeted = jogadorService.getById(jogador.getId());

        assertEquals(expeted, jogador);
        verify(jogadorRepo).findJogadorEntityByIdAndAtivoTrue(jogador.getId());
    }

    @Test
    void canNotGetAJogaorByIdIfDoNotFind() {
        JogadorEntity jogador = new JogadorEntity(
                1l,
                "e",
                "e",
                new ArrayList<PersonagemEntity>(),
                true);

        when(jogadorRepo.findJogadorEntityByIdAndAtivoTrue(jogador.getId())).thenReturn(Optional.ofNullable(null));

        assertThrows(JogadorNaoEncontrado.class, () -> {
            jogadorService.getById(jogador.getId());
        });
    }

    @Test
    void cutUpdateaJogador(){
        JogadorEntity jogador = new JogadorEntity(
                1l,
                "e",
                "e",
                new ArrayList<PersonagemEntity>(),
                true);
        
        JogadorEntity newJogador = new JogadorEntity(
                "e",
                "e",
                new ArrayList<PersonagemEntity>(),
                true);
        
        given(jogadorRepo.findJogadorEntityByIdAndAtivoTrue(jogador.getId())).willReturn(Optional.of(jogador));

        jogadorService.put(jogador.getId(), newJogador);

        verify(jogadorRepo).findJogadorEntityByIdAndAtivoTrue(jogador.getId());
        verify(jogadorRepo).save(newJogador);
    }

    @Test
    void canDalete(){
        JogadorEntity jogador = new JogadorEntity(
                1l,
                "e",
                "e",
                new ArrayList<PersonagemEntity>(),
                true);

        given(jogadorRepo.findJogadorEntityByIdAndAtivoTrue(jogador.getId())).willReturn(Optional.of(jogador));

        jogadorService.delete(jogador.getId());

        assertFalse(jogador.getAtivo());
        verify(jogadorRepo).save(jogador);
    }

    @Test
    void canGetAllByName(){
        jogadorService.getAllByNome("JOJO");

        verify(jogadorRepo).findJogadorEntityByAtivoTrueAndNomeContaining("JOJO");
    }

    @Test
    void canAddApersonagenIntoAJogador(){
        JogadorEntity jogador = new JogadorEntity(
                2l,
                "e",
                "e",
                new ArrayList<PersonagemEntity>(),
                true);
        
        PersonagemEntity personagemEntity = new PersonagemEntity(2L,"nome", "apelido", Genero.FEMININO, 13, 13, 15, 20, 10, Clase.BRUXO);

        given(jogadorRepo.findJogadorEntityByIdAndAtivoTrue(jogador.getId())).willReturn(Optional.of(jogador));
        given(personagemService.getById(personagemEntity.getId())).willReturn(personagemEntity);

        personagemEntity.setJogador(jogador);

        given(personagemService.put(personagemEntity.getId(), personagemEntity)).willReturn(personagemEntity);

        jogadorService.AtribuirPersonagemAUmJogador(personagemEntity.getId(), jogador.getId());

        assertTrue(jogador.getPersonagens().contains(personagemEntity));
        assertEquals(jogador, personagemEntity.getJogador());

        verify(jogadorRepo).save(jogador);
    }

}
