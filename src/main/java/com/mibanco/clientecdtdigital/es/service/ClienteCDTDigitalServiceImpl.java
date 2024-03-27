package com.mibanco.clientecdtdigital.es.service;
import com.google.protobuf.Empty;
import com.google.protobuf.Int64Value;
import com.mibanco.clientecdtdigital.es.dao.ClienteCDTDigitalDao;
import com.mibanco.clientecdtdigital.es.entity.ClienteCDTDigital;
import com.mibanco.clientecdtdigital.es.proto.service.Cliente;
import com.mibanco.clientecdtdigital.es.proto.service.ClienteCDTDigitalService;
import com.mibanco.clientecdtdigital.es.utils.ClienteCDTDigitalMapper;
import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Uni;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@GrpcService
public class ClienteCDTDigitalServiceImpl implements ClienteCDTDigitalService {
    private  static  final Logger LOG = LoggerFactory.getLogger(ClienteCDTDigitalServiceImpl.class);

    private final ClienteCDTDigitalMapper mapper;
    private final ClienteCDTDigitalDao dao;

    public ClienteCDTDigitalServiceImpl(ClienteCDTDigitalMapper mapper, ClienteCDTDigitalDao dao){
        this.mapper = mapper;
        this.dao = dao;
    }


    @Override
    public Uni<Cliente> create(Cliente request) {
        ClienteCDTDigital cliente = mapper.clienteCDTDigitalTypeToEntity(request);
        return dao.persistAndFlush(cliente).map(mapper::entityToClienteCDTDigitalType);
    }

    @Override
    public Uni<Cliente> update(Cliente request) {
        return null;
    }

    @Override
    public Uni<Cliente> finById(Int64Value request) {
        return null;
    }

    @Override
    public Uni<Cliente> list(Empty request) {
        return null;
    }

    @Override
    public Uni<Cliente> delete(Int64Value request) {
        return null;
    }
}
