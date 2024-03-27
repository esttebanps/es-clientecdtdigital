package com.mibanco.clientecdtdigital.es.resource;

import com.mibanco.clientecdtdigital.es.dto.ClienteCDTDigitalRequest;
import com.mibanco.clientecdtdigital.es.proto.service.ClienteCDTDigitalService;
import com.mibanco.clientecdtdigital.es.utils.ClienteCDTDigitalMapper;
import io.quarkus.grpc.GrpcClient;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;

@Path("/clientecdtdigital")
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteCDTDigitalResource {
    @GrpcClient("clienteCDTDigital-service")
    ClienteCDTDigitalService clienteCDTDigitalService;
    @Inject
    ClienteCDTDigitalMapper clienteCDTDigitalMapper;

    @POST
    public Uni<Response> create(ClienteCDTDigitalRequest clienteRequest) {
        return clienteCDTDigitalService.create(clienteCDTDigitalMapper.clienteCDTDigitalRequestToCliente(clienteRequest)).onItem().transform(inserted -> Response.created(URI.create("/clientecdtdigital/" + inserted.getId())).build());
    }
}
