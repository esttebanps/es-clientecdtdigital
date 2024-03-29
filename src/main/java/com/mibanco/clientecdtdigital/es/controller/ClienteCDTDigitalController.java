package com.mibanco.clientecdtdigital.es.controller;

import com.mibanco.clientecdtdigital.es.gen.contract.V1ClientecdtdigitalApi;
import com.mibanco.clientecdtdigital.es.gen.type.ClienteCDTDigitalType;
import com.mibanco.clientecdtdigital.es.gen.type.ClienteCDTDigitalTypeResponse;
import com.mibanco.clientecdtdigital.es.service.implemt.ClienteCDTDigitalImpl;
import com.mibanco.clientecdtdigital.es.utils.ApplicationException;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.mibanco.clientecdtdigital.es.constant.Constant.ERROR_SERVICIO;


public class ClienteCDTDigitalController implements V1ClientecdtdigitalApi {
    private static final Logger LOG = LoggerFactory.getLogger(ClienteCDTDigitalController.class);

    @Inject
    ClienteCDTDigitalImpl clienteCDTDigitalImpl;

    @Override
    public Response actualizarClienteCDTDigital(Integer id, ClienteCDTDigitalTypeResponse clienteCDTDigitalTypeResponse) {
        LOG.info("Inicio actualizarClienteCDTDigital controller");
        try {
            Long idCliente = Long.valueOf(id);
            clienteCDTDigitalImpl.actualizarClienteCDTDigital(idCliente, clienteCDTDigitalTypeResponse);
        } catch (ApplicationException e) {
            LOG.error("Se presento un error en el metodo actualizarClienteCDTDigital controller" + e.getMessage());
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage() + "actualizarClienteCDTDigital controller");
        }
        return Response.status(Response.Status.ACCEPTED).entity(clienteCDTDigitalTypeResponse).build();
    }

    @Override
    public Response crearClienteCDTDigital(ClienteCDTDigitalType clienteCDTDigitalType) {
        LOG.info("Inicio crearClienteCdtDigital controller");
        try {
            clienteCDTDigitalImpl.crearClienteCDTDigital(clienteCDTDigitalType);
            LOG.info("Fin crearClienteCdtDigital controller");
        } catch (ApplicationException e) {
            LOG.error("Se presento un error en el metodo CrearClienteCDTDigital controller" + e.getMessage());
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage() + "crearClienteCdtDigital controller");
        }
        return Response.status(Response.Status.CREATED).entity(clienteCDTDigitalType).build();
    }

    @Override
    public Response eliminarClienteCDTDigital(Integer id) {
        LOG.info("Inicio eliminarClienteCDTDigital controller");
        try {
            Long idCliente = Long.valueOf(id);
            clienteCDTDigitalImpl.eliminarClienteCDTDigital(idCliente);
            LOG.info("Fin eliminarClienteCDTDigital controller");
        } catch (ApplicationException e) {
            LOG.error("Se presento un error en el metodo eliminarClienteCDTDigital controller" + e.getMessage());
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage() + "eliminarClienteCDTDigital controller");
        }
        return Response.status(Response.Status.OK).build();
    }

    @Override
    public Response obtenerClienteCDTDigital() {
        LOG.info("Inicio obtenerClienteCDTDigital controller");
        List<ClienteCDTDigitalTypeResponse> clientes;
        try {
            clientes = clienteCDTDigitalImpl.obtenerClienteCDTDigital();
            LOG.info("Fin obtenerClienteCDTDigital controller");
        } catch (ApplicationException e) {
            LOG.error("Se presento un error en el metodo obtenerClienteCDTDigital controller" + e.getMessage());
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage() + "obtenerClienteCDTDigital controller");
        }
        return Response.status(Response.Status.OK).entity(clientes).build();
    }
}
