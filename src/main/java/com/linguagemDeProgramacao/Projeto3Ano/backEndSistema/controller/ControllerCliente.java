package com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.classes.Cliente;
import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.repositorio.ClienteRepositorio;
import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.requests.ClientePostRequestBody;
import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.requests.ClientePutRequestBody;
import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.service.ServiceCliente;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("cliente")
public class ControllerCliente {

    private final ServiceCliente serviceCliente;
    private final ClienteRepositorio clienteRepositorio;

    @GetMapping(path = "lista")
    public ResponseEntity<List<Cliente>> lista(){
        
        return  ResponseEntity.ok(serviceCliente.listarTudo());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Cliente> findbyId(@PathVariable long id){
        return  ResponseEntity.ok(serviceCliente.findById(id));
    }
    @GetMapping(value = "buscarNome")
    public ResponseEntity<List<Cliente>> buscarPlaca(@RequestParam(name = "nome") String nome){
        List<Cliente> cliente = clienteRepositorio.buscarNome(nome.trim().toUpperCase());
        return new ResponseEntity<List<Cliente>>(cliente, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody ClientePostRequestBody clientePostRequestBody){
        return new ResponseEntity<>(serviceCliente.save(clientePostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        serviceCliente.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody ClientePutRequestBody clientePutRequestBody) {
        serviceCliente.replace(clientePutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
