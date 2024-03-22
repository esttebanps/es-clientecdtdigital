package com.mibanco.clientecdtdigital.es.service.implemt;

import com.mibanco.clientecdtdigital.es.dao.ClienteCDTDigitalDao;
import com.mibanco.clientecdtdigital.es.entity.ClienteCDTDigital;
import com.mibanco.clientecdtdigital.es.utils.ClienteCDTDigitalMapper;

import com.mibanco.clientecdtdigital.es.service.contract.IClienteCDTDigital;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.Column;
import jakarta.transaction.Transactional;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.List;

import static com.mibanco.clientecdtdigital.es.constant.Constant.ERROR_SERVICIO;


@ApplicationScoped
public class ClienteCDTDigitalImpl implements IClienteCDTDigital{
    private static final Logger LOG = LoggerFactory.getLogger(ClienteCDTDigitalImpl.class);

    @Inject
    ClienteCDTDigitalDao clienteCDTDigitalDao;

    @Inject
    ClienteCDTDigitalMapper clienteCDTDigitalMapper;

    @Transactional
    public ClienteCDTDigital crearClienteCDTDigital(ClienteCDTDigital clienteCDTDigital){
        clienteCDTDigitalDao.persist(clienteCDTDigital);
        return clienteCDTDigital;
    }

    @Transactional
    public ClienteCDTDigital actualizarClienteCDTDigital(Integer id, ClienteCDTDigital clienteCDTDigital){
        Long idCliente = Long.valueOf(id);
        ClienteCDTDigital cliente = clienteCDTDigitalDao.findById(idCliente);
        cliente.setTipoTelefonoPrincipal(clienteCDTDigital.getTipoTelefonoPrincipal());
        cliente.setTelefonoPrincipal(clienteCDTDigital.getTelefonoPrincipal());
        cliente.setTipoCorreoElectronico(clienteCDTDigital.getTipoCorreoElectronico());
        return clienteCDTDigital;
    }

    public List<ClienteCDTDigital> obtenerClienteCDTDigital(){
        return clienteCDTDigitalDao.listAll();
    }



}
