package com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.requests;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class FuncionarioPostRequestBody {
    
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
