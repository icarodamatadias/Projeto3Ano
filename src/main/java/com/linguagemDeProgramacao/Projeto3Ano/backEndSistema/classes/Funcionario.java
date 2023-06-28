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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Funcionario")
    private Long id;
	private String nome;
	private String cpf;
	private int nascimento;
	private String email;
	private String contato;
    private String nMatricula;
	private String cargaH;
	private String especialidade;
	private int salario;
}
