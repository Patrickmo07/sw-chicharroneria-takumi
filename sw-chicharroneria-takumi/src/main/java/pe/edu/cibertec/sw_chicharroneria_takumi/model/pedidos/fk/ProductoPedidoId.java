package pe.edu.cibertec.sw_chicharroneria_takumi.model.pedidos.fk;


import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class ProductoPedidoId implements Serializable {
    private  Integer id_producto;
    private  Integer id_pedido;
}
