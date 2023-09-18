package com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.classes.Cliente;
import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.exceptions.BadRequestException;
import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.mappers.ClienteMapper;
import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.repositorio.ClienteRepositorio;
import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.requests.ClientePostRequestBody;
import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.requests.ClientePutRequestBody;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServiceCliente {
    
    private final ClienteRepositorio clienteRepositorio;

    public Page<Cliente> listarTudo(Pageable pageable){
        return clienteRepositorio.findAll(pageable);
    }

    public List<Cliente> listAllNonPageable() {
        return clienteRepositorio.findAll();

    }

    public Cliente findById(long id){
        return  clienteRepositorio.findById(id)
        .orElseThrow(() -> new BadRequestException("Cliente não encontrado"));
    }

    @Transactional
    public Cliente save(ClientePostRequestBody clientePostRequestBody){
            
        return clienteRepositorio.save(ClienteMapper.INSTANCE.toCliente(clientePostRequestBody));
    }

    public void delete(long id) {
        clienteRepositorio.delete(findById(id));
    }

    public void replace(ClientePutRequestBody clientePutRequestBody) {
        Cliente clienteSaved = findById(clientePutRequestBody.getId());
        Cliente cliente = ClienteMapper.INSTANCE.toCliente(clientePutRequestBody);    
        cliente.setId(clienteSaved.getId());
        clienteRepositorio.save(cliente);
    }
}
