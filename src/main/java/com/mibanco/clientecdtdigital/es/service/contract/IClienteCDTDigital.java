package com.mibanco.clientecdtdigital.es.service.contract;

import com.mibanco.clientecdtdigital.es.entity.ClienteCDTDigital;
import jakarta.transaction.Transactional;

import java.util.List;

public interface IClienteCDTDigital {
    @Transactional
    public ClienteCDTDigital crearClienteCDTDigital(ClienteCDTDigital clienteCDTDigital);

    @Transactional
    public ClienteCDTDigital actualizarClienteCDTDigital(Integer id, ClienteCDTDigital clienteCDTDigital);

    public List<ClienteCDTDigital> obtenerClienteCDTDigital();

    @Transactional
    public boolean eliminarClienteCDTDigital(Integer id );
}
