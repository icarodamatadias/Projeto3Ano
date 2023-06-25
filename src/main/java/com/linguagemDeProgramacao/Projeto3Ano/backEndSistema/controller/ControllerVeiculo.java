package com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.controller;


import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.classes.Veiculo;
import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.requests.VeiculoPostRequestBody;
import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.requests.VeiculoPutRequestBody;
import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.service.ServiceVeiculo;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("veiculo")
public class ControllerVeiculo {

    private final ServiceVeiculo serviceVeiculo;


    @GetMapping(path = "lista")
    public ResponseEntity<List<Veiculo>> lista(){
        
        return  ResponseEntity.ok(serviceVeiculo.listarTudo());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Veiculo> findbyId(@PathVariable long id){
        return  ResponseEntity.ok(serviceVeiculo.findById(id));
    }

    @PostMapping
    public ResponseEntity<Veiculo> save(@RequestBody VeiculoPostRequestBody veiculoPostRequestBody){
        return new ResponseEntity<>(serviceVeiculo.save(veiculoPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        serviceVeiculo.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    
    public ResponseEntity<Void> replace(@RequestBody VeiculoPutRequestBody veiculoPutRequestBody) {
        serviceVeiculo.replace(veiculoPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
