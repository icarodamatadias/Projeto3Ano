package com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.requests;

import lombok.Data;

@Data
public class ClientePostRequestBody {
    
    private String nome;
	private String cpf;
	private int nascimento;
	private String email;
	private String contato;
    private String senha;
	private String login;
}
