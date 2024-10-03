package com.api.spring_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class SpringApiApplication {

	public static void main(String[] args) {
		// Carregar o arquivo .env
		Dotenv dotenv = Dotenv.load();

		// Definir as variáveis de ambiente manualmente
		System.setProperty("DB_URL", dotenv.get("DB_URL"));
		System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
		System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));

		SpringApplication.run(SpringApiApplication.class, args);
	}

}
