package com.javier.ms_pedidos.service;

import com.javier.ms_pedidos.dto.EstadoPedidoDTO;
import com.javier.ms_pedidos.dto.PedidoRequestDTO;
import com.javier.ms_pedidos.entity.EstadoPedido;
import com.javier.ms_pedidos.entity.Pedido;
import com.javier.ms_pedidos.exception.PedidoNotFoundException;
import com.javier.ms_pedidos.repository.PedidoRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository repository;

    @Override
    public Pedido crearPedido(PedidoRequestDTO dto) {

        BigDecimal total =
                dto.getPrecioUnitario()
                        .multiply(BigDecimal.valueOf(dto.getCantidad()));

        Pedido pedido = Pedido.builder()
                .cliente(dto.getCliente())
                .correoCliente(dto.getCorreoCliente())
                .productoId(dto.getProductoId())
                .nombreProducto(dto.getNombreProducto())
                .cantidad(dto.getCantidad())
                .precioUnitario(dto.getPrecioUnitario())
                .total(total)
                .estado(EstadoPedido.REGISTRADO)
                .fechaPedido(LocalDateTime.now())
                .build();

        return repository.save(pedido);
    }

    @Override
    public List<Pedido> listarPedidos() {
        return repository.findAll();
    }

    @Override
    public Pedido obtenerPedido(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new PedidoNotFoundException("No existe el pedido nro: "+id));
    }

    @Override
    public Pedido actualizarEstado(Long id, EstadoPedidoDTO dto) {

        Pedido pedido = obtenerPedido(id);

        if (pedido.getEstado() == EstadoPedido.CANCELADO
                && dto.getEstado() != EstadoPedido.CANCELADO) {
            throw new IllegalStateException("Pedido cancelado no se puede reactivar");
        }
        pedido.setEstado(dto.getEstado());

        return repository.save(pedido);
    }

    @Override
    public void eliminarPedido(Long id) {

        Pedido pedido = obtenerPedido(id);
        pedido.setEstado(EstadoPedido.CANCELADO);

        repository.save(pedido);
    }
}
