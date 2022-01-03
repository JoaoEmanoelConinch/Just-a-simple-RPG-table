package br.com.joao.justasimplerpgtable.Jogador;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.joao.justasimplerpgtable.model.entity.JogadorEntity;
import br.com.joao.justasimplerpgtable.model.entity.PersonagemEntity;
import br.com.joao.justasimplerpgtable.model.repository.JogadorRepo;
import br.com.joao.justasimplerpgtable.model.service.JogadorService;
import br.com.joao.justasimplerpgtable.model.service.PersonagemService;

@DataJpaTest
public class JogadorServiceTest {
    
    @Mock
    private JogadorRepo jogadorRepo;

    @Mock
    private PersonagemService personagemService;
    private AutoCloseable autoCloseable;

    private JogadorService jogadorService;

    @BeforeEach
    void setUp(){
        autoCloseable = MockitoAnnotations.openMocks(this);
        jogadorService = new JogadorService(jogadorRepo, personagemService);
    }

    @AfterEach
    void TearDow() throws Exception{
        autoCloseable.close();
    }

    @Test
    void cangetAll(){
        //when
        jogadorService.getAll();

        //then
        verify(jogadorRepo).findAll();
    }

    @Test
    void canAddJogador(){
        JogadorEntity jogador = new JogadorEntity(
            "e",
            "e",
            new ArrayList<PersonagemEntity>(),
            true
        );
        jogadorService.save(jogador);

        ArgumentCaptor<JogadorEntity> argumentCaptor = ArgumentCaptor.forClass(JogadorEntity.class);
        
        verify(jogadorRepo).save(argumentCaptor.capture());

        JogadorEntity jogadorArgment = argumentCaptor.getValue();

        assertEquals(jogador, jogadorArgment);
        
    }

}
