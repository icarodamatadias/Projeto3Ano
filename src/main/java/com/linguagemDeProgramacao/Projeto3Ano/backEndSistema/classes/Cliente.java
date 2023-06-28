package com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.classes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Data
public class Cliente {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCliente")
    private Long id;
	private String nome;
	private String cpf;
	private int nascimento;
	private String email;
	private String contato;
    private String senha;
	private String login;

}
