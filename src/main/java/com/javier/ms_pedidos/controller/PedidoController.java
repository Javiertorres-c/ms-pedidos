package com.javier.ms_pedidos.controller;

import com.javier.ms_pedidos.dto.EstadoPedidoDTO;
import com.javier.ms_pedidos.dto.PedidoRequestDTO;
import com.javier.ms_pedidos.entity.Pedido;
import com.javier.ms_pedidos.service.PedidoService;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import java.time.LocalDateTime;
import com.javier.ms_pedidos.dto.ErrorResponse;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido crear(@Valid @RequestBody PedidoRequestDTO dto) {
        return service.crearPedido(dto);
    }

    @GetMapping
    public List<Pedido> listar() {
        return service.listarPedidos();
    }

    @GetMapping("/{id}")
    public Pedido obtener(@PathVariable Long id) {
        return service.obtenerPedido(id);
    }

    @PatchMapping("/{id}/estado")
    public Pedido actualizarEstado(
            @PathVariable Long id,
            @Valid @RequestBody EstadoPedidoDTO dto) {

        return service.actualizarEstado(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ErrorResponse> eliminar(@PathVariable Long id) {

        service.eliminarPedido(id);

        ErrorResponse response = ErrorResponse.builder()
                .mensaje("Pedido cancelado")
                .detalle("El pedido fue cancelado correctamente")
                .fecha(LocalDateTime.now())
                .build();

        return ResponseEntity.ok(response);
    }
}
