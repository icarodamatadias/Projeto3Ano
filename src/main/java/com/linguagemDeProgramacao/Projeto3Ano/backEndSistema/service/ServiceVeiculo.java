package com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.classes.Veiculo;
import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.exceptions.BadRequestException;
import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.mappers.VeiculoMapper;
import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.repositorio.VeiculoRepositorio;
import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.requests.VeiculoPostRequestBody;
import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.requests.VeiculoPutRequestBody;


import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ServiceVeiculo {

    private final VeiculoRepositorio veiculoRepositorio;


    public Page<Veiculo> listarTudo(Pageable pageable){
        return veiculoRepositorio.findAll(pageable);
    }

    public List<Veiculo> listAllNonPageable() {
        return veiculoRepositorio.findAll();
    }
    
    public Veiculo findById(long id){

        return  veiculoRepositorio.findById(id)
        .orElseThrow(() -> new BadRequestException("Veículo não encontrado"));
    }

    @Transactional
    public Veiculo save(VeiculoPostRequestBody veiculoPostRequestBody){
            
        return veiculoRepositorio.save(VeiculoMapper.INSTANCE.toVeiculo(veiculoPostRequestBody));
    }

    public void delete(long id) {
        veiculoRepositorio.delete(findById(id));
    }

    
    public void replace(VeiculoPutRequestBody veiculoPutRequestBody) {
        Veiculo savedVeiculo = findById(veiculoPutRequestBody.getId());
        Veiculo veiculo = VeiculoMapper.INSTANCE.toVeiculo(veiculoPutRequestBody);    
        veiculo.setId(savedVeiculo.getId());
    
        veiculoRepositorio.save(veiculo);
    }
}