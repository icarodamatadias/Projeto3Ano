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

import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.classes.Funcionario;
import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.repositorio.FuncionarioRepositorio;
import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.requests.FuncionarioPostRequestBody;
import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.requests.FuncionarioPutRequestBody;
import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.service.ServiceFuncionario;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("funcionario")
public class ControllerFuncionario {

    private final ServiceFuncionario serviceFuncionario;
    private final FuncionarioRepositorio funcionarioRepositorio;

    @GetMapping(path = "lista")
    public ResponseEntity<List<Funcionario>> lista(){
        
        return  ResponseEntity.ok(serviceFuncionario.listarTudo());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Funcionario> findbyId(@PathVariable long id){
        return  ResponseEntity.ok(serviceFuncionario.findById(id));
    }

    @GetMapping(value = "buscarNome")
    public ResponseEntity<List<Funcionario>> buscarPlaca(@RequestParam(name = "nome") String nome){
        List<Funcionario> cliente = funcionarioRepositorio.buscarNome(nome.trim().toUpperCase());
        return new ResponseEntity<List<Funcionario>>(cliente, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Funcionario> save(@RequestBody FuncionarioPostRequestBody funcionarioPostRequestBody){
        return new ResponseEntity<>(serviceFuncionario.save(funcionarioPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        serviceFuncionario.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody FuncionarioPutRequestBody clientePutRequestBody) {
        serviceFuncionario.replace(clientePutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}