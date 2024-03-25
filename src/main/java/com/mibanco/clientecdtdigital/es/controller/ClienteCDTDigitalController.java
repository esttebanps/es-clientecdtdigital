package com.mibanco.clientecdtdigital.es.controller;

import com.mibanco.clientecdtdigital.es.entity.ClienteCDTDigital;
import com.mibanco.clientecdtdigital.es.service.implemt.ClienteCDTDigitalImpl;
import com.mibanco.clientecdtdigital.es.utils.ApplicationException;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.graphql.*;
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
        LOG.info("Inicio crearClienteCDTDigital controller");
        try{
            ClienteCDTDigital cliente = clienteCDTDigitalImpl.crearClienteCDTDigital(clienteCDTDigital);
            LOG.info("Fin crearClienteCDTDigital controller");
            return cliente;
        } catch (ApplicationException e){
            LOG.error("Se presento un error en el metodo crearClienteCDTDigital controller" + e.getMessage());
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage() + "crearClienteCDTDigital controller");
        }
    }

    @Mutation
    @Description("Actualizar ClienteCDTDigital")
    public ClienteCDTDigital actualizarClienteCDTDigital(Integer id, ClienteCDTDigital clienteCDTDigital){
        LOG.info("Inicio actualizarClienteCDTDigital controller");
        try{
            ClienteCDTDigital cliente = clienteCDTDigitalImpl.actualizarClienteCDTDigital(id,clienteCDTDigital);
            LOG.info("Fin actualizarClienteCDTDigital controller");
            return cliente;
        } catch (ApplicationException e){
            LOG.error("Se presento un error en el metodo actualizarClienteCDTDigital controller" + e.getMessage());
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage() + "actualizarClienteCDTDigital controller");
        }
    }

    @Query
    @Description("Obtener ClienteCDTDigital")
    public List<ClienteCDTDigital> obtenerClienteCDTDigital(){
        LOG.info("Inicio obtenerClienteCDTDigital controller");
        try {
            List<ClienteCDTDigital> clientes = clienteCDTDigitalImpl.obtenerClienteCDTDigital();
            LOG.info("Fin obtenerClienteCDTDigital controller");
            return clientes;
        } catch (ApplicationException e){
            LOG.error("Se presento un error en el metodo obtenerClienteCDTDigital controller" + e.getMessage());
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage() + "obtenerClienteCDTDigital controller");
        }
    }

    @Mutation
    @Description("Eliminar ClienteCDTDigital")
    public boolean eliminarClienteCDTDigital(@Name("id") Integer id){
        LOG.info("Inicio eliminarClienteCDTDigital controller");
        try {
            boolean cliente = clienteCDTDigitalImpl.eliminarClienteCDTDigital(id);
            LOG.info("Fin eliminarClienteCDTDigital controller");
            return cliente;
        } catch (ApplicationException e){
            LOG.error("Se presento un error en el metodo eliminarClienteCDTDigital controller" + e.getMessage());
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage() + "eliminarClienteCDTDigital controller");
        }
    }
}
