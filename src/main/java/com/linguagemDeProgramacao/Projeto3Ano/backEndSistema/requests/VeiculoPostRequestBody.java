package com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.requests;

import javax.validation.constraints.NotEmpty;

import lombok.Data;


@Data
public class VeiculoPostRequestBody {

    @NotEmpty
	private String rodas;

	@NotEmpty
	private String placa;

	@NotEmpty
	private String modelo;

	@NotEmpty
	private String marca;

	@NotEmpty
	private String descricao;

	@NotEmpty
	private String estado_conservacao;
}