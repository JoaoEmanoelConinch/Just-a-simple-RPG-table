package br.com.joao.justasimplerpgtable;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.joao.justasimplerpgtable.model.entity.JogadorEntity;
import br.com.joao.justasimplerpgtable.model.service.*;


@SpringBootApplication
public class JustasimplerpgtableApplication {

	public static void main(String[] args) {
		SpringApplication.run(JustasimplerpgtableApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner (JogadorService jogadorService) {
		return args -> {
			System.out.println();
			List<JogadorEntity> jogadorEntities = jogadorService.getAll();
			jogadorEntities.stream().forEach(e -> System.out.println(e.getAtivo()));
			System.out.println();
		};
	}
	
}
