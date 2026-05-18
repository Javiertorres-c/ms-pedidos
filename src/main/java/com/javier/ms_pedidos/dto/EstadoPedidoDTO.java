package com.javier.ms_pedidos.dto;

import com.javier.ms_pedidos.entity.EstadoPedido;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadoPedidoDTO {

    @NotNull(message = "El estado es obligatorio")
    private EstadoPedido estado;
}