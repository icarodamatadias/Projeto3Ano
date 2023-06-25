package com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.classes.Veiculo;
import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.repositorio.VeiculoRepositorio;
import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.requests.VeiculoPostRequestBody;
import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.requests.VeiculoPutRequestBody;


import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ServiceVeiculo {

    private final VeiculoRepositorio veiculoRepositorio;


    public List<Veiculo> listarTudo(){
        return veiculoRepositorio.findAll();
    }

    
    public Veiculo findById(long id){

        return  veiculoRepositorio.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
         "Veículo não encontrado"));
    }


    public Veiculo save(VeiculoPostRequestBody veiculoPostRequestBory){
            
        return veiculoRepositorio.save(
            Veiculo.builder()
                .placa(veiculoPostRequestBory.getPlaca())
                .modelo(veiculoPostRequestBory.getModelo())
                .marca(veiculoPostRequestBory.getMarca())
                .rodas(veiculoPostRequestBory.getRodas())
                .descricao(veiculoPostRequestBory.getDescricao())
                .estado_conservacao(veiculoPostRequestBory.getEstado_conservacao())
                .build()
            
            );
    }

    public void delete(long id) {
        veiculoRepositorio.delete(findById(id));
    }

    
    public void replace(VeiculoPutRequestBody veiculoPutRequestBody) {
        findById(veiculoPutRequestBody.getId());
        Veiculo veiculo = Veiculo.builder()
            .placa(veiculoPutRequestBody.getPlaca())
            .modelo(veiculoPutRequestBody.getModelo())
            .marca(veiculoPutRequestBody.getMarca())
            .rodas(veiculoPutRequestBody.getRodas())
            .descricao(veiculoPutRequestBody.getDescricao())
            .estado_conservacao(veiculoPutRequestBody.getEstado_conservacao())
            .build();
        
        veiculoRepositorio.save(veiculo);
    }
}
