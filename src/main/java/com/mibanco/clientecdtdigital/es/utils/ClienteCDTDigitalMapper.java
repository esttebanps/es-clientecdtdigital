package com.mibanco.clientecdtdigital.es.utils;

import com.mibanco.clientecdtdigital.es.dto.ClienteCDTDigitalRequest;
import com.mibanco.clientecdtdigital.es.entity.ClienteCDTDigital;
import com.mibanco.clientecdtdigital.es.proto.service.Cliente;
import org.mapstruct.Mapper;
import org.modelmapper.ModelMapper;

@Mapper(componentModel = "jakarta")
public class ClienteCDTDigitalMapper {

    public ClienteCDTDigital clienteCDTDigitalTypeToEntity(Cliente cliente){
        ClienteCDTDigital clienteCDTDigital = new ClienteCDTDigital();
        clienteCDTDigital.setTipoCorreoElectronico(cliente.getTipoCorreoElectronico());
        clienteCDTDigital.setTelefonoPrincipal(cliente.getTelefonoPrincipal());
        return clienteCDTDigital;
    }
    public Cliente entityToClienteCDTDigitalType(ClienteCDTDigital clienteCDTDigital){
        return new ModelMapper().map(clienteCDTDigital, Cliente.class);
    }

    public Cliente clienteCDTDigitalRequestToCliente(ClienteCDTDigitalRequest clienteCDTDigitalRequest){
        return  new  ModelMapper().map(clienteCDTDigitalRequest, Cliente.class);
    }

}
