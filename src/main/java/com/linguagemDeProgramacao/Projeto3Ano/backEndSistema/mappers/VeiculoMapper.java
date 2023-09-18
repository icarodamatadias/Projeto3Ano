package com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.classes.Veiculo;
import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.requests.VeiculoPostRequestBody;
import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.requests.VeiculoPutRequestBody;


@Mapper(componentModel =  "spring")
public abstract class VeiculoMapper {

    public static final VeiculoMapper INSTANCE = Mappers.getMapper(VeiculoMapper.class);

    public abstract Veiculo toVeiculo(VeiculoPostRequestBody veiculoPostRequestBody);
    public abstract Veiculo toVeiculo(VeiculoPutRequestBody veiculoPutRequestBody);
    
}