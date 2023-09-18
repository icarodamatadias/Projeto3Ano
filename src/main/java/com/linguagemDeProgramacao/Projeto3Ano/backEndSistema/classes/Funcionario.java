package com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.classes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

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
	@NotEmpty
	private String nome;
	@NotEmpty
	private String cpf;
	@NotEmpty
	private int nascimento;
	@NotEmpty
	private String email;
	@NotEmpty
	private String contato;
	@NotEmpty
    private String nMatricula;
	@NotEmpty
	private String cargaH;
	@NotEmpty
	private String especialidade;
	@NotEmpty
	private int salario;
}
