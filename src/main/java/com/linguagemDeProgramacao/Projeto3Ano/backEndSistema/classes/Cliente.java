package com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.classes;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cliente extends Pessoa{
    
    private String senha;
	private String login;
}
