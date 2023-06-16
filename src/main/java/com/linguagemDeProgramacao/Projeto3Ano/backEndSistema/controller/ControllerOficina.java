package com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.controller;


import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.classes.Veiculo;
//import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.requests.VeiculoPostRequestBody;
//import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.requests.VeiculoPutRequestBody;
import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.service.ServiceOficina;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("veiculo")
public class ControllerOficina {

    private final ServiceOficina serviceOficina;


    @GetMapping(path = "lista")
    public ResponseEntity<List<Veiculo>> lista(){
        
        return  ResponseEntity.ok(serviceOficina.listarTudo());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Veiculo> findbyId(@PathVariable long id){
        
        return ResponseEntity.ok(serviceOficina.findById(id));

        //return  ResponseEntity.ok(serviceOficina.findbyId(id));
    }

    @PostMapping
        public ResponseEntity<Veiculo> save(@RequestBody Veiculo veiculo) {
        return new ResponseEntity<>(serviceOficina.save(veiculo), HttpStatus.CREATED);
        }
    /*public ResponseEntity<Veiculo> save(@RequestBody VeiculoPostRequestBody veiculoPostRequestBody){
        return new ResponseEntity<>(serviceOficina.save(veiculoPostRequestBody), HttpStatus.CREATED);
    }*/

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        serviceOficina.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
        public ResponseEntity<Void> replace(@RequestBody Veiculo veiculo) {
        serviceOficina.replace(veiculo);
    /*public ResponseEntity<Void> replace(@RequestBody VeiculoPutRequestBody veiculoPutRequestBody) {
        serviceOficina.replace(veiculoPutRequestBody);*/
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
