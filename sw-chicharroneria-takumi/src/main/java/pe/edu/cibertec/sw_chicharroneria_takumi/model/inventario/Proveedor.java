package pe.edu.cibertec.sw_chicharroneria_takumi.model.inventario;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Proveedor")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_proveedor;
    @Column(name = "nombre_proveedor")
    private String nombre_proveedor;
    @Column(name = "contacto_proveedor")
    private String contacto_proveedor;
    @Column(name = "telefono_proveedor")
    private String telefono_proveedor;
    @Column(name = "direccion_proveedor")
    private String direccion_proveedor;
}
