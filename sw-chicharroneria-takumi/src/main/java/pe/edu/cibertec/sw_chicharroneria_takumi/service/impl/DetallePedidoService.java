package pe.edu.cibertec.sw_chicharroneria_takumi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibertec.sw_chicharroneria_takumi.dto.DetallePedidoDto;
import pe.edu.cibertec.sw_chicharroneria_takumi.model.pedidos.DetallePedido;
import pe.edu.cibertec.sw_chicharroneria_takumi.model.pedidos.fk.ProductoPedidoId;
import pe.edu.cibertec.sw_chicharroneria_takumi.repository.DetallePedidoRepository;
import pe.edu.cibertec.sw_chicharroneria_takumi.service.IDetallePedidoService;

@RequiredArgsConstructor
@Service
public class DetallePedidoService implements IDetallePedidoService {

    private final DetallePedidoRepository detallePedidoRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public DetallePedido registrarDetallePedido(DetallePedidoDto detallePedidoDto) {

            ProductoPedidoId productoPedidoId = new ProductoPedidoId();
            productoPedidoId.setId_pedido(detallePedidoDto.getId_producto());
            productoPedidoId.setId_producto(detallePedidoDto.getId_pedido());

            DetallePedido detallePedido = new DetallePedido();
            detallePedido.setId(productoPedidoId);
            detallePedido.setCantidad(detallePedidoDto.getCantidad());


            return detallePedidoRepository.save(detallePedido);
    }

}
