package com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.classes;


import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Cliente extends Pessoa{
    
    private String senha;
	private String login;
}
