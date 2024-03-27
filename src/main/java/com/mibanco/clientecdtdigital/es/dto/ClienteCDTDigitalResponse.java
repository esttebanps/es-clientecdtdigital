package com.mibanco.clientecdtdigital.es.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ClienteCDTDigitalResponse {
    private Long id;
    private String telefonoPrincipal;
    private String tipoCorreoElectronico;
}