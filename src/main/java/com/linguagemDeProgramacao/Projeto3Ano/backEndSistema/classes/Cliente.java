package com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.classes;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Data
public class Cliente {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCliente")
    private Long id;
	@NotEmpty
	private String nome;
	@NotEmpty
	private String cpf;
	@NotEmpty
	private int nascimento;
	@NotEmpty
	private String email;
	@NotEmpty
	private String contato;
	@NotEmpty
    private String senha;
	@NotEmpty
	private String login;

	@JsonManagedReference
	@OneToMany(mappedBy = "id_Proprietario")	
	private List<Veiculo> id_Veiculos;

}
