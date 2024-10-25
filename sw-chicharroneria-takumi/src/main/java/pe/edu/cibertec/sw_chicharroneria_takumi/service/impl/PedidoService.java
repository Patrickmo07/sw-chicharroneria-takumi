package pe.edu.cibertec.sw_chicharroneria_takumi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibertec.sw_chicharroneria_takumi.dto.DetallePedidoDto;
import pe.edu.cibertec.sw_chicharroneria_takumi.dto.PedidoDto;
import pe.edu.cibertec.sw_chicharroneria_takumi.model.cliente.Clientes;
import pe.edu.cibertec.sw_chicharroneria_takumi.model.pedidos.Pedido;
import pe.edu.cibertec.sw_chicharroneria_takumi.repository.PedidoRepository;
import pe.edu.cibertec.sw_chicharroneria_takumi.service.IDetallePedidoService;
import pe.edu.cibertec.sw_chicharroneria_takumi.service.IPedidoService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PedidoService implements IPedidoService {

    private final PedidoRepository pedidoRepository;
    private final IDetallePedidoService detallePedidoService;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Pedido registarPedido(PedidoDto pedidoDto) {
        Pedido pedido = new Pedido();
        Clientes clientes = new Clientes();
        clientes.setId_cliente(pedidoDto.getId_cliente());
        pedido.setClientes(clientes);
        Pedido nuevoPedido = pedidoRepository.save(pedido);

        for (DetallePedidoDto detallePedidoDto : pedidoDto.getDetallePedidoDtos()){
detallePedidoDto.setId_pedido(nuevoPedido.getId_pedido());
detallePedidoService.registrarDetallePedido(detallePedidoDto);
        }
        return nuevoPedido;
           }

    @Override
    public Pedido guardarPedido(Pedido pedido) {
        return  pedidoRepository.save(pedido);
    }

    @Override
    public List<Pedido> obtnPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Optional<Pedido> obtnPedido(Integer id) {
        return pedidoRepository.findById(id);
    }

    @Override
    public Optional<Pedido> obtnPedidoXTipo(Boolean tipo_entrega) {
        return pedidoRepository.findByPedidoandtipo(tipo_entrega);
    }
}
