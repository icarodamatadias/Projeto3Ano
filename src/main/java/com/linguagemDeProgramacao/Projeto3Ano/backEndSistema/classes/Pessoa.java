package com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.classes;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;



@MappedSuperclass
public abstract class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String nome;
	private String cpf;
	private int nascimento;
	private String email;
	private String contato;
}
