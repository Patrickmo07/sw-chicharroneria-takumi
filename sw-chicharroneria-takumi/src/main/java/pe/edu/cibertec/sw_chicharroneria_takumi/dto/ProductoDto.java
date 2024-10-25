package pe.edu.cibertec.sw_chicharroneria_takumi.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductoDto {
    private Integer id_producto;
    private String nombre_producto;
    private String descripcion;
    private Integer categoriaId_categoria;
}
