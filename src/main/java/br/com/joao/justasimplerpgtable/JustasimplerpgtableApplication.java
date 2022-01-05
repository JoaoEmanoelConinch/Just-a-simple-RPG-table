package br.com.joao.justasimplerpgtable;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.joao.justasimplerpgtable.model.entity.JogadorEntity;
import br.com.joao.justasimplerpgtable.model.repository.JogadorRepo;
import br.com.joao.justasimplerpgtable.model.*;


@SpringBootApplication
public class JustasimplerpgtableApplication {

	public static void main(String[] args) {
		SpringApplication.run(JustasimplerpgtableApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner (JogadorRepo jogadorRepo) {
		return args -> {
			System.out.println();
			System.out.println(jogadorRepo.existsJogadorEntityByNome("Joao"));
			System.out.println();
		};
	}
	
}
