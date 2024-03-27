package com.mibanco.clientecdtdigital.es.dao;

import com.mibanco.clientecdtdigital.es.entity.ClienteCDTDigital;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.common.annotation.Blocking;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Blocking
public class ClienteCDTDigitalDao implements PanacheRepository<ClienteCDTDigital> {
}
