package pe.edu.cibertec.sw_chicharroneria_takumi.model.pedidos;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pe.edu.cibertec.sw_chicharroneria_takumi.model.cliente.Clientes;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pedido;
    @ManyToOne
    @JoinColumn(name =  "id_cliente")
    private Clientes clientes;
    private Date fecha_pedido;
    private Boolean tipo_entrega;
    private String estado_pedido;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL,orphanRemoval = true)
@JsonManagedReference
    private Set<DetallePedido> product = new HashSet<>();

    private Double total;

}
