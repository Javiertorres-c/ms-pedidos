package com.javier.ms_pedidos.service;

import com.javier.ms_pedidos.dto.EstadoPedidoDTO;
import com.javier.ms_pedidos.dto.PedidoRequestDTO;
import com.javier.ms_pedidos.entity.Pedido;

import java.util.List;

public interface PedidoService {

    Pedido crearPedido(PedidoRequestDTO dto);

    List<Pedido> listarPedidos();

    Pedido obtenerPedido(Long id);

    Pedido actualizarEstado(Long id, EstadoPedidoDTO dto);

    void eliminarPedido(Long id);
}