package pe.edu.cibertec.sw_chicharroneria_takumi.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CategoriaDto {
    private Integer id_categoria;
    private String nombre_categoria;
}
