package com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.classes.Funcionario;
import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.requests.FuncionarioPostRequestBody;
import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.requests.FuncionarioPutRequestBody;


@Mapper(componentModel =  "spring")
public abstract class FuncionarioMapper {

    public static final FuncionarioMapper INSTANCE = Mappers.getMapper(FuncionarioMapper.class);

    public abstract Funcionario toFuncionario(FuncionarioPostRequestBody funcionarioPostRequestBody);
    public abstract Funcionario toFuncionario(FuncionarioPutRequestBody funcionarioPutRequestBody);
    
}