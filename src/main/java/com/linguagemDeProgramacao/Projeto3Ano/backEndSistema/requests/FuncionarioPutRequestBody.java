package com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.requests;

import lombok.Data;

@Data
public class FuncionarioPutRequestBody {
    
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
