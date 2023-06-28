package com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.classes.Cliente;
import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.repositorio.ClienteRepositorio;
import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.requests.ClientePostRequestBody;
import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.requests.ClientePutRequestBody;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServiceCliente {
    
    private final ClienteRepositorio clienteRepositorio;

    public List<Cliente> listarTudo(){
        return clienteRepositorio.findAll();
    }

    public Cliente findById(long id){

        return  clienteRepositorio.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
         "Veículo não encontrado"));
    }

    public Cliente save(ClientePostRequestBody clientePostRequestBody){
            
        return clienteRepositorio.save(
            Cliente.builder()
                .nome(clientePostRequestBody.getNome())
                .cpf(clientePostRequestBody.getCpf())
                .nascimento(clientePostRequestBody.getNascimento())
                .email(clientePostRequestBody.getEmail())
                .contato(clientePostRequestBody.getContato())
                .senha(clientePostRequestBody.getSenha())
                .login(clientePostRequestBody.getLogin())
                .build()
            
            );
    }

    public void delete(long id) {
        clienteRepositorio.delete(findById(id));
    }

    public void replace(ClientePutRequestBody clientePutRequestBody) {
        findById(clientePutRequestBody.getId());
        Cliente cliente = Cliente.builder()
            .nome(clientePutRequestBody.getNome())
            .cpf(clientePutRequestBody.getCpf())
            .nascimento(clientePutRequestBody.getNascimento())
            .email(clientePutRequestBody.getEmail())
            .contato(clientePutRequestBody.getContato())
            .senha(clientePutRequestBody.getSenha())
            .login(clientePutRequestBody.getLogin())
            .build();
        
        clienteRepositorio.save(cliente);
    }
}
