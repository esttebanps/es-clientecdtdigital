package com.mibanco.clientecdtdigital.es.service.implemt;

import com.mibanco.clientecdtdigital.es.dao.ClienteCDTDigitalDao;
import com.mibanco.clientecdtdigital.es.entity.ClienteCDTDigital;

import com.mibanco.clientecdtdigital.es.service.contract.IClienteCDTDigital;
import com.mibanco.clientecdtdigital.es.utils.ApplicationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.List;

import static com.mibanco.clientecdtdigital.es.constant.Constant.ERROR_SERVICIO;


@ApplicationScoped
public class ClienteCDTDigitalImpl implements IClienteCDTDigital {
    private static final Logger LOG = LoggerFactory.getLogger(ClienteCDTDigitalImpl.class);

    @Inject
    ClienteCDTDigitalDao clienteCDTDigitalDao;

    @Transactional
    public ClienteCDTDigital crearClienteCDTDigital(ClienteCDTDigital clienteCDTDigital) {
        LOG.info("Inicio crearClienteCDTDigital impl");
        try {
            clienteCDTDigitalDao.persist(clienteCDTDigital);
            LOG.info("Fin crearClienteCDTDigital impl");
            return clienteCDTDigital;
        } catch (ApplicationException e) {
            LOG.error("Se presento un error en el metodo crearClienteCDTDigital impl" + e.getMessage());
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage() + "crearClienteCDTDigital impl");
        }
    }

    @Transactional
    public ClienteCDTDigital actualizarClienteCDTDigital(Integer id, ClienteCDTDigital clienteCDTDigital) {
        LOG.info("Inicio actualizarClienteCDTDigital impl");
        try {
            Long idCliente = Long.valueOf(id);
            ClienteCDTDigital cliente = clienteCDTDigitalDao.findById(idCliente);
            cliente.setTipoTelefonoPrincipal(clienteCDTDigital.getTipoTelefonoPrincipal());
            cliente.setTelefonoPrincipal(clienteCDTDigital.getTelefonoPrincipal());
            cliente.setTipoCorreoElectronico(clienteCDTDigital.getTipoCorreoElectronico());
            LOG.info("Fin actualizarClienteCDTDigital impl");
            return clienteCDTDigital;
        } catch (ApplicationException e) {
            LOG.error("Se presento un error en el metodo actualizarClienteCDTDigital impl" + e.getMessage());
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage() + "actualizarClienteCDTDigital impl");
        }
    }

    public List<ClienteCDTDigital> obtenerClienteCDTDigital() {
        LOG.info("Inicio obtenerClienteCDTDigital impl");
        try {
            List<ClienteCDTDigital> clientes = clienteCDTDigitalDao.listAll();
            LOG.info("Fin obtenerClienteCDTDigital impl");
            return clientes;
        } catch (ApplicationException e) {
            LOG.error("Se presento un error en el metodo obtenerClienteCDTDigital impl" + e.getMessage());
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage() + "obtenerClienteCDTDigital impl");
        }
    }

    @Transactional
    public boolean eliminarClienteCDTDigital(Integer id) {
        LOG.info("Inicio eliminarClienteCDTDigital impl");
        try {
            Long idCliente = Long.valueOf(id);
            boolean cliente = clienteCDTDigitalDao.deleteById(idCliente);
            LOG.info("Fin eliminarClienteCDTDigital impl");
            return cliente;
        } catch (ApplicationException e) {
            LOG.error("Se presento un error en el metodo eliminarClienteCDTDigital impl" + e.getMessage());
            throw new ApplicationException(ERROR_SERVICIO + e.getMessage() + "eliminarClienteCDTDigital impl");
        }
    }
}
