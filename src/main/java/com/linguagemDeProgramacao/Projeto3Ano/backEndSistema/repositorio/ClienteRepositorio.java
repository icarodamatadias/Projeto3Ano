package com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.repositorio;

import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.classes.Cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ClienteRepositorio extends JpaRepository<Cliente, Long>{
    
    @Query(value = "select c from Cliente c where upper(trim(c.nome)) like %?1%")
    List<Cliente> buscarNome(String nome);
}
