package com.linguagemDeProgramacao.Projeto3Ano;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class Projeto3AnoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Projeto3AnoApplication.class, args);
	}

}
