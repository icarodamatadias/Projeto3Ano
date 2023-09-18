package com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.requests;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class ClientePostRequestBody {
    
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
    private String senha;

	@NotEmpty
	private String login;
}
