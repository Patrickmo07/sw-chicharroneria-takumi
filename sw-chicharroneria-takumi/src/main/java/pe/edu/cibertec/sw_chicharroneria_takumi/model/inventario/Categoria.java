package pe.edu.cibertec.sw_chicharroneria_takumi.model.inventario;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_categoria;
    @Column(name = "nombre_categoria")
    private String nombre_categoria;
}
