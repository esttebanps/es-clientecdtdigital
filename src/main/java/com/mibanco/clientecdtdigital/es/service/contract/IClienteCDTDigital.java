package com.mibanco.clientecdtdigital.es.service.contract;

import com.mibanco.clientecdtdigital.es.gen.type.ClienteCDTDigitalType;
import jakarta.transaction.Transactional;

public interface IClienteCDTDigital {
    @Transactional
    public ClienteCDTDigitalType crearClienteCDTDigital(ClienteCDTDigitalType ClienteCDTDigitalType);
}
