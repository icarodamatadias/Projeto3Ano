package com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.repositorio;

import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.classes.Veiculo;
//import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OficinaRepositorio /*extends JpaRepository<Veiculo, Long>*/{
    List<Veiculo> listAll();
}
