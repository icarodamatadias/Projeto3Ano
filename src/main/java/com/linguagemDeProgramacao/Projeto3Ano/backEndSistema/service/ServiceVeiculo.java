package com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.classes.Veiculo;
//import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.repositorio.OficinaRepositorio;
//import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.requests.VeiculoPostRequestBody;
//import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.requests.VeiculoPutRequestBody;


import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


@Service
@RequiredArgsConstructor
public class ServiceVeiculo {

    //private final OficinaRepositorio oficinaRepositorio;

    private static List<Veiculo> veiculos;

    static{
        veiculos = new ArrayList<>(List.of(new Veiculo( 1L, 4, "gfm 8753",
         "corola", "toyota",
        "problema de ignição", "cemi-novo")));
    }

    public List<Veiculo> listarTudo(){
        return veiculos;
        //return oficinaRepositorio.findAll();
    }

    
    public Veiculo findById(long id){
        
        return veiculos.stream()
                .filter(veiculo -> veiculo.getId().equals(id))
                .findFirst()
        //return  oficinaRepositorio.findById(id)
        
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
         "Veículo não encontrado"));
    }


    public Veiculo save(Veiculo veiculo){ 
        veiculo.setId(ThreadLocalRandom.current().nextLong(3, 100000));
            veiculos.add(veiculo);
            return veiculo;
        
        
        /*public Veiculo save(VeiculoPostRequestBody veiculoPostRequestBory){
              
        return oficinaRepositorio.save(
            Veiculo.builder()
                .placa(veiculoPostRequestBory.getPlaca())
                .modelo(veiculoPostRequestBory.getModelo())
                .marca(veiculoPostRequestBory.getMarca())
                .rodas(veiculoPostRequestBory.getRodas())
                .descricao(veiculoPostRequestBory.getDescricao())
                .estado_conservacao(veiculoPostRequestBory.getEstado_conservacao())
                .build()
            
            );*/
    }

    public void delete(long id) {
        veiculos.remove(findById(id));

        //oficinaRepositorio.delete(findbyId(id));
    }

    public void replace(Veiculo veiculo) {
        delete(veiculo.getId());
        veiculos.add(veiculo);
    /* 
    public void replace(VeiculoPutRequestBody veiculoPutRequestBody) {
        findbyId(veiculoPutRequestBody.getId());
        Veiculo veiculo = Veiculo.builder()
            .placa(veiculoPutRequestBody.getPlaca())
            .modelo(veiculoPutRequestBody.getModelo())
            .marca(veiculoPutRequestBody.getMarca())
            .rodas(veiculoPutRequestBody.getRodas())
            .descricao(veiculoPutRequestBody.getDescricao())
            .estado_conservacao(veiculoPutRequestBody.getEstado_conservacao())
            .build();
        
        oficinaRepositorio.save(veiculo);*/
    }
}
