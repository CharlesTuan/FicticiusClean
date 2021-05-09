package br.com.ficticiusclean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		// Inicia o servidor TomCat da aplicação
		SpringApplication.run(DemoApplication.class, args);
	}

}
