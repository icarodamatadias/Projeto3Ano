package com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.classes;



/*import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;*/

import lombok.AllArgsConstructor;
//import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Entity
//@Builder
public class Veiculo {

	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//private Long idProprietario;
	private int rodas;
	private String placa;
	private String modelo;
	private String marca;
	private String descricao;
	private String estado_conservacao;
}