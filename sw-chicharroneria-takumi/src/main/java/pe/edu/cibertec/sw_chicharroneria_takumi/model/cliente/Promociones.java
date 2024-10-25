package pe.edu.cibertec.sw_chicharroneria_takumi.model.cliente;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Promociones")
public class Promociones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_promocion;
    @Column(name = "descripcion_promocion")
    private String descripcion_promocion;
    @Column(name = "puntos_necesarios")
    private Integer puntos_necesarios;
    @Column(name = "descuento")
    private Double descuento;
}
