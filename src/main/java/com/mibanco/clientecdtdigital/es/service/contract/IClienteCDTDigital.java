package com.mibanco.clientecdtdigital.es.service.contract;

import com.mibanco.clientecdtdigital.es.entity.ClienteCDTDigital;
import jakarta.transaction.Transactional;

public interface IClienteCDTDigital {
    @Transactional
    public ClienteCDTDigital crearClienteCDTDigital(ClienteCDTDigital clienteCDTDigital);
}
