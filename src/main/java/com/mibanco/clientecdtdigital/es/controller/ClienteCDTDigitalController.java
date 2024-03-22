package com.mibanco.clientecdtdigital.es.controller;

import com.mibanco.clientecdtdigital.es.entity.ClienteCDTDigital;
import com.mibanco.clientecdtdigital.es.service.implemt.ClienteCDTDigitalImpl;
import com.mibanco.clientecdtdigital.es.utils.ApplicationException;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.mibanco.clientecdtdigital.es.constant.Constant.ERROR_SERVICIO;

@GraphQLApi
public class ClienteCDTDigitalController {
    private static final Logger LOG = LoggerFactory.getLogger(ClienteCDTDigitalController.class);

    @Inject
    ClienteCDTDigitalImpl clienteCDTDigitalImpl;

    @Mutation
    @Description("Crear ClienteCDTDigital")
    public ClienteCDTDigital crearClienteCDTDigital(ClienteCDTDigital clienteCDTDigital){
        return clienteCDTDigitalImpl.crearClienteCDTDigital(clienteCDTDigital);
    }

    @Query
    @Description("Obtener ClienteCDTDigital")
    public List<ClienteCDTDigital> obtenerClienteCDTDigital(){
        return clienteCDTDigitalImpl.obtenerClienteCDTDigital();
    }

}
