package pe.edu.cibertec.sw_chicharroneria_takumi.model.inventario;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Inventario")
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_inventario;
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;
    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private Proveedor proveedor;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "tipo_movimiento")
    private String tipo_movimiento;
}
