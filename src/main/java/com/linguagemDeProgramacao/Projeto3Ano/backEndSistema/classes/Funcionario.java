package com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.classes;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Funcionario extends Pessoa{

    private String nMatricula;
	private String cargaH;
	private String especialidade;
	private int salario;
}
