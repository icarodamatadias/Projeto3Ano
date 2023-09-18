package com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.classes.Funcionario;
import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.exceptions.BadRequestException;
import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.mappers.FuncionarioMapper;
import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.repositorio.FuncionarioRepositorio;
import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.requests.FuncionarioPostRequestBody;
import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.requests.FuncionarioPutRequestBody;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServiceFuncionario {
    
    private final FuncionarioRepositorio funcionarioRepositorio;

    public Page<Funcionario> listarTudo(Pageable pageable){
        return funcionarioRepositorio.findAll(pageable);
    } 

    public List<Funcionario> listAllNonPageable() {
        return funcionarioRepositorio.findAll();
    }

    public Funcionario findById(long id){

        return  funcionarioRepositorio.findById(id)
        .orElseThrow(() -> new BadRequestException("funcionario não encontrado"));

    }

    @Transactional
    public Funcionario save(FuncionarioPostRequestBody funcionarioPostRequestBody){
            
        return funcionarioRepositorio.save(FuncionarioMapper.INSTANCE.toFuncionario(funcionarioPostRequestBody));

    }

    public void delete(long id) {
        funcionarioRepositorio.delete(findById(id));
    }

    public void replace(FuncionarioPutRequestBody funcionarioPutRequestBody) {
        Funcionario savedfuncionario = findById(funcionarioPutRequestBody.getId());
        Funcionario funcionario = FuncionarioMapper.INSTANCE.toFuncionario(funcionarioPutRequestBody);
        funcionario.setId(savedfuncionario.getId());
        funcionarioRepositorio.save(funcionario);
    } 
}
