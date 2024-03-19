package com.mibanco.clientecdtdigital.es.service.implemt;

import com.mibanco.clientecdtdigital.es.dao.ClienteCDTDigitalDao;
import com.mibanco.clientecdtdigital.es.utils.ClienteCDTDigitalMapper;

import com.mibanco.clientecdtdigital.es.service.contract.IClienteCDTDigital;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.inject.Inject;



public class ClienteCDTDigital implements IClienteCDTDigital {
    //private  static  final Logger LOG = LoggerFactory.getLogger(UsuarioController.class);
    @Inject
    ClienteCDTDigitalDao ClienteCDTDigitalDao;
    @Inject
    ClienteCDTDigitalMapper ClienteCDTDigitalMapper;

    //public com.mibanco.clientecdtdigital.es.entity.ClienteCDTDigital CreateClienteCDTDigital()


}
