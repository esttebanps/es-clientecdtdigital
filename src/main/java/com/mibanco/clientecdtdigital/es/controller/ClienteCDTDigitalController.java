package com.mibanco.clientecdtdigital.es.controller;

import com.mibanco.clientecdtdigital.es.gen.contract.V1ClientecdtdigitalApi;
import com.mibanco.clientecdtdigital.es.gen.type.ClienteCDTDigitalType;
import com.mibanco.clientecdtdigital.es.service.implemt.ClienteCDTDigitalImpl;
import com.mibanco.clientecdtdigital.es.utils.ApplicationException;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.mibanco.clientecdtdigital.es.constant.Constant.ERROR_SERVICIO;


public class ClienteCDTDigitalController implements V1ClientecdtdigitalApi {
    private static final Logger LOG = LoggerFactory.getLogger(ClienteCDTDigitalController.class);
    @Inject
    ClienteCDTDigitalImpl clienteCDTDigitalImpl;

    @Override
    public Response crearClienteCDTDigital(ClienteCDTDigitalType clienteCDTDigitalType) {
        LOG.info("Inicio crearClienteCdtDigital controller");
        try {
            clienteCDTDigitalImpl.crearClienteCDTDigital(clienteCDTDigitalType);
            LOG.info("Fin crearClienteCdtDigital controller");
        } catch (ApplicationException e) {
            LOG.error("Se presento un error en el metodo CrearClienteCDTDigital Impl" + e.getMessage());
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage() + "crearClienteCdtDigital controller");
        }
        return Response.status(Response.Status.CREATED).entity(clienteCDTDigitalType).build();
    }
}
