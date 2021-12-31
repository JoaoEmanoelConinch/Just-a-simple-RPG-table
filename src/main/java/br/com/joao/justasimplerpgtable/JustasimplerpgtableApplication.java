package br.com.joao.justasimplerpgtable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class JustasimplerpgtableApplication {

	public static void main(String[] args) {
		SpringApplication.run(JustasimplerpgtableApplication.class, args);
	}

	// @Bean
	// CommandLineRunner commandLineRunner (JogadorService jogadorService) {
	// 	return args -> {
	// 		System.out.println();
	// 		System.out.println(jogadorService.getAllByNome("Joao").get(0).getNome());
	// 		System.out.println();
	// 	};
	// }
	
}
