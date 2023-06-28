package com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.repositorio;

import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.classes.Funcionario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface FuncionarioRepositorio extends JpaRepository<Funcionario, Long>{
    
    @Query(value = "select f from Funcionario f where upper(trim(f.nome)) like %?1%")
    List<Funcionario> buscarNome(String nome);
}
