package com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.controller;


import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.classes.Veiculo;
import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.repositorio.VeiculoRepositorio;
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
    private final VeiculoRepositorio veiculoRepositorio;


    @GetMapping(path = "lista")
    public ResponseEntity<List<Veiculo>> lista(){
        
        return  ResponseEntity.ok(serviceVeiculo.listarTudo());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Veiculo> findbyId(@PathVariable long id){
        return  ResponseEntity.ok(serviceVeiculo.findById(id));
    }

    @GetMapping(value = "buscarPlaca")
    public ResponseEntity<List<Veiculo>> buscarPlaca(@RequestParam(name = "placa") String placa){
        List<Veiculo> veiculo = veiculoRepositorio.buscarPlaca(placa.trim().toUpperCase());
        return new ResponseEntity<List<Veiculo>>(veiculo, HttpStatus.OK);
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
