package com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.classes.Funcionario;
import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.repositorio.FuncionarioRepositorio;
import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.requests.FuncionarioPostRequestBody;
import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.requests.FuncionarioPutRequestBody;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServiceFuncionario {
    
    private final FuncionarioRepositorio funcionarioRepositorio;

    public List<Funcionario> listarTudo(){
        return funcionarioRepositorio.findAll();
    }

    public Funcionario findById(long id){

        return  funcionarioRepositorio.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
         "Veículo não encontrado"));
    }

    public Funcionario save(FuncionarioPostRequestBody funcionarioPostRequestBody){
            
        return funcionarioRepositorio.save(
            Funcionario.builder()
                .nome(funcionarioPostRequestBody.getNome())
                .cpf(funcionarioPostRequestBody.getCpf())
                .nascimento(funcionarioPostRequestBody.getNascimento())
                .email(funcionarioPostRequestBody.getEmail())
                .contato(funcionarioPostRequestBody.getContato())
                .nMatricula(funcionarioPostRequestBody.getNMatricula())
                .cargaH(funcionarioPostRequestBody.getCargaH())
                .especialidade(funcionarioPostRequestBody.getCargaH())
                .salario(funcionarioPostRequestBody.getSalario())
                .build()
            
            );
    }

    public void delete(long id) {
        funcionarioRepositorio.delete(findById(id));
    }

    public void replace(FuncionarioPutRequestBody funcionarioPutRequestBody) {
        findById(funcionarioPutRequestBody.getId());
        Funcionario funcionario = Funcionario.builder()
            .nome(funcionarioPutRequestBody.getNome())
            .cpf(funcionarioPutRequestBody.getCpf())
            .nascimento(funcionarioPutRequestBody.getNascimento())
            .email(funcionarioPutRequestBody.getEmail())
            .contato(funcionarioPutRequestBody.getContato())
            .nMatricula(funcionarioPutRequestBody.getNMatricula())
            .cargaH(funcionarioPutRequestBody.getCargaH())
            .especialidade(funcionarioPutRequestBody.getCargaH())
            .salario(funcionarioPutRequestBody.getSalario())
            .build();
        
        funcionarioRepositorio.save(funcionario);
    }
}
