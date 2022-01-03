package br.com.joao.justasimplerpgtable.Personagem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.joao.justasimplerpgtable.model.entity.PersonagemEntity;
import br.com.joao.justasimplerpgtable.model.exceptiom.PersonagemNaoEncontrado;
import br.com.joao.justasimplerpgtable.model.enumeratiom.Clase;
import br.com.joao.justasimplerpgtable.model.enumeratiom.Genero;
import br.com.joao.justasimplerpgtable.model.repository.PersonagemRepo;

import static org.mockito.BDDMockito.given;
import br.com.joao.justasimplerpgtable.model.service.PersonagemService;

@DataJpaTest
public class PersonagemServiseTest {
    
    @Mock
    private PersonagemRepo personagemRepo;

    PersonagemService personagemService;
    AutoCloseable autoCloseable;

    PersonagemEntity personagemEntity;
    Long id;

    @BeforeEach
    void setUp(){
        autoCloseable = MockitoAnnotations.openMocks(this);
        personagemService = new PersonagemService(personagemRepo);
    }

    @BeforeEach
    void begin(){
        id = 1l;
        personagemEntity = new PersonagemEntity(id,"nome", "apelido", Genero.FEMININO, 13, 13, 15, 20, 10, Clase.BRUXO);
    }

    @AfterEach
    void end(){
        personagemRepo.deleteAll();
    }

    @AfterEach
    void TearDow() throws Exception{
        autoCloseable.close();
    }

    @Test
    void deveSavar(){
        personagemService.save(personagemEntity);

        ArgumentCaptor<PersonagemEntity> argument = ArgumentCaptor.forClass(PersonagemEntity.class);

        verify(personagemRepo).save(argument.capture());

        PersonagemEntity personagemEntity = argument.getValue();

        assertEquals(personagemEntity, personagemEntity);
    }

    @Test 
    void deveEncontarPersonagemPorId(){
        when(personagemRepo.findById(id)).thenReturn(Optional.of(personagemEntity));

        PersonagemEntity expetedEntity = personagemService.getById(id);

        assertEquals(expetedEntity, personagemEntity);
        verify(personagemRepo).findById(id);
    }

    @Test
    void deveLancasExecaoPorNaoEncontrarPersonagen(){
        given(personagemRepo.findById(id)).willReturn(Optional.ofNullable(null));

        assertThrows(PersonagemNaoEncontrado.class, ()-> {personagemService.getById(id);});
    }

    @Test
    void devePegarTodos(){
        personagemService.getAll();
        verify(personagemRepo).findAll();
    }

    @Test
    void deveAtualizarPersonagem(){
        PersonagemEntity newPersonagemEntity = new PersonagemEntity("nomee", "apeliido", Genero.MASCULINO, 17, 17, 17, 27, 17, Clase.ARQUEIRO);

        given(personagemRepo.findById(personagemEntity.getId())).willReturn(Optional.of(personagemEntity));
        personagemService.put(id, newPersonagemEntity);

        verify(personagemRepo).findById(id);
        verify(personagemRepo).save(newPersonagemEntity);

    }

    @Test
    void DeveDeletar(){
        when(personagemRepo.findById(id)).thenReturn(Optional.of(personagemEntity));

        personagemService.delete(id);
        verify(personagemRepo).deleteById(id);
    }

}
