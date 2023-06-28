package com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.repositorio;

import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.classes.Veiculo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface VeiculoRepositorio extends JpaRepository<Veiculo, Long>{

    @Query(value = "select v from Veiculo v where upper(trim(v.placa)) like %?1%")
    List<Veiculo> buscarPlaca(String placa);
}
