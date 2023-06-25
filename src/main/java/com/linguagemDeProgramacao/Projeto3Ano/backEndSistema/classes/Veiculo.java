package com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.classes;



import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idVeiculo")
	private Long id;
	//private Long idProprietario;
	
	@Column
	private int rodas;

	@Column
	private String placa;

	@Column
	private String modelo;

	@Column
	private String marca;

	@Column
	private String descricao;

	@Column
	private String estado_conservacao;
}