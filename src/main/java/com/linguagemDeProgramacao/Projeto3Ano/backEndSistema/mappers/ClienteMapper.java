package com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.classes.Cliente;
import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.requests.ClientePostRequestBody;
import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.requests.ClientePutRequestBody;


@Mapper(componentModel =  "spring")
public abstract class ClienteMapper {

    public static final ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    public abstract Cliente toCliente(ClientePostRequestBody clientePostRequestBody);
    public abstract Cliente toCliente(ClientePutRequestBody clientePutRequestBody);
    
}