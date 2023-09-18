package com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.classes;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

	@JsonBackReference
	@ManyToOne
	@JoinColumn
	private Cliente id_Proprietario;
}