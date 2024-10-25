package pe.edu.cibertec.sw_chicharroneria_takumi.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Builder
@Data
public class PedidoDto {
    private Integer id_pedido;
    private Integer id_cliente;
    private Date fecha_pedido;
    private String estado_pedido;
    private Double total;

    private List<DetallePedidoDto> detallePedidoDtos;
}
