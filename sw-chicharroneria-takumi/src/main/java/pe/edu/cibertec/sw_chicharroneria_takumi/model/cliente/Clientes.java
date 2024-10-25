package pe.edu.cibertec.sw_chicharroneria_takumi.model.cliente;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Clientes")
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cliente;
    @Column(name = "nombre_cliente")
    private String nombre_cliente;
    @Column(name = "telefono_cliente")
    private String telefono_cliente;
    @Column(name = "correo_cliente")
    private String correo_cliente;
    @Column(name = "puntos_fidelidad")
    private Integer puntos_fidelidad;
}
