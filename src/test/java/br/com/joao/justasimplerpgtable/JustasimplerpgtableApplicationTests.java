package br.com.joao.justasimplerpgtable;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JustasimplerpgtableApplicationTests {

	private Calc calc = new Calc();
	
	@Test
	void contextLoads() {
		//given
		int numero1 = 10;
		int numero2 = 10;

		// when
		int add = calc.add(numero1,numero2);

		//then
		assertEquals(20, add);
	}
	class Calc{
		int add(int a, int b){
			return a+b;
		}
	}
}
