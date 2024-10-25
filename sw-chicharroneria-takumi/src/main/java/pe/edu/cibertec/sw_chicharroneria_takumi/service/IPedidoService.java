package pe.edu.cibertec.sw_chicharroneria_takumi.service;

import pe.edu.cibertec.sw_chicharroneria_takumi.dto.PedidoDto;
import pe.edu.cibertec.sw_chicharroneria_takumi.model.pedidos.Pedido;

import java.util.List;
import java.util.Optional;

public interface IPedidoService {

    Pedido registarPedido(PedidoDto pedidodto);
    Pedido guardarPedido(Pedido pedido);
    List<Pedido> obtnPedidos();
    Optional<Pedido> obtnPedido(Integer id);
    Optional<Pedido>  obtnPedidoXTipo(Boolean tipo_entrega);
}
