package pe.edu.cibertec.sw_chicharroneria_takumi.model.pedidos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.edu.cibertec.sw_chicharroneria_takumi.model.inventario.Producto;
import pe.edu.cibertec.sw_chicharroneria_takumi.model.pedidos.fk.ProductoPedidoId;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "detallepedido")
public class DetallePedido {

    @EmbeddedId
    private ProductoPedidoId id;

    @ManyToOne
    @MapsId("id_pedido")
    @JoinColumn (name = "id_pedido")
    @JsonBackReference
    private Pedido id_pedido;

    @ManyToOne
    @MapsId("id_producto")
    @JoinColumn (name ="id_producto")
    @JsonBackReference
    private Producto producto;


    private Integer cantidad;
    private BigDecimal precio;
}
