package pe.edu.cibertec.sw_chicharroneria_takumi.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DetallePedidoDto {
    private Integer id_detalle;
    private Integer id_pedido;
    private Integer id_producto;
    private Integer cantidad;
    private Double precio;
}
