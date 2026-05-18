package com.javier.ms_pedidos.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ErrorResponse {

    private String mensaje;
    private String detalle;
    private LocalDateTime fecha;
}
