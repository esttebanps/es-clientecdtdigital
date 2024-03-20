package com.mibanco.clientecdtdigital.es.controller;

import com.mibanco.clientecdtdigital.es.gen.contract.V1ClientecdtdigitalApi;
import com.mibanco.clientecdtdigital.es.gen.type.ClienteCDTDigitalType;
import com.mibanco.clientecdtdigital.es.service.implemt.ClienteCDTDigitalImpl;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

public class ClienteCDTDigitalController implements V1ClientecdtdigitalApi {
    @Inject
    ClienteCDTDigitalImpl clienteCDTDigitalImpl;

    @Override
    public Response crearClienteCdtDigital(ClienteCDTDigitalType clienteCDTDigitalType) {
        clienteCDTDigitalImpl.CreateClienteCDTDigital(clienteCDTDigitalType);
        return Response.status(Response.Status.CREATED).entity(clienteCDTDigitalType).build();
    }
}
