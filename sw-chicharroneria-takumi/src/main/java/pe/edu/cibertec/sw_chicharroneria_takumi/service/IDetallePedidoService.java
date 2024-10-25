package pe.edu.cibertec.sw_chicharroneria_takumi.service;

import pe.edu.cibertec.sw_chicharroneria_takumi.dto.DetallePedidoDto;
import pe.edu.cibertec.sw_chicharroneria_takumi.model.pedidos.DetallePedido;

public interface IDetallePedidoService {
    DetallePedido registrarDetallePedido(DetallePedidoDto detallePedido);
}
