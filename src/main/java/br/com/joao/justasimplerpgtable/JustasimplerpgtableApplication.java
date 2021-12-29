package br.com.joao.justasimplerpgtable;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.joao.justasimplerpgtable.model.entity.JogadorEntity;
import br.com.joao.justasimplerpgtable.model.entity.PersonagemEntity;
import br.com.joao.justasimplerpgtable.model.enumeratiom.Clase;
import br.com.joao.justasimplerpgtable.model.enumeratiom.Genero;
import br.com.joao.justasimplerpgtable.model.enumeratiom.StatusJogador;
import br.com.joao.justasimplerpgtable.model.service.JogadorService;

@SpringBootApplication
public class JustasimplerpgtableApplication {

	public static void main(String[] args) {
		SpringApplication.run(JustasimplerpgtableApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner (JogadorService jogadorService, ) {
//		return args -> {
//			JogadorEntity jogador = new JogadorEntity("Jotaro", "Jojo", StatusJogador.AVENTUREIRO, new ArrayList<PersonagemEntity>() ,true);
//			PersonagemEntity personagem = new PersonagemEntity("Daniel", "Dan", Genero.MASCULINO, Short.valueOf("10"),Short.valueOf ("10"), Short.valueOf ("10"),Short.valueOf ("10") , Short.valueOf("10"), Clase.GUERREIRO);
//			PersonagemEntity newPersonagem = 
//		};
//	}
	
}
