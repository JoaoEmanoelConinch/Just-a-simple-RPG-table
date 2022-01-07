package br.com.joao.justasimplerpgtable;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.joao.justasimplerpgtable.model.entity.JogadorEntity;
import br.com.joao.justasimplerpgtable.model.entity.PersonagemEntity;
import br.com.joao.justasimplerpgtable.model.repository.JogadorRepo;
import br.com.joao.justasimplerpgtable.model.service.JogadorService;
import br.com.joao.justasimplerpgtable.model.*;


@SpringBootApplication
public class JustasimplerpgtableApplication {

	public static void main(String[] args) {
		SpringApplication.run(JustasimplerpgtableApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner (JogadorService jogadorService) {
		return args -> {
			System.out.println();
			JogadorEntity jogador =jogadorService.getByNameAndPassword("JOJO", "ORAORA");
			System.out.println();
			System.out.println(jogador.getSenha());
			System.out.println();
		};
	}
	
}
