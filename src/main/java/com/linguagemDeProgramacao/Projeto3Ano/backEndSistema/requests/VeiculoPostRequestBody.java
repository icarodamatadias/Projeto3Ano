package com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.requests;

import lombok.Data;


@Data
public class VeiculoPostRequestBody {

    
	private String rodas;
	private String placa;
	private String modelo;
	private String marca;
	private String descricao;
	private String estado_conservacao;
}