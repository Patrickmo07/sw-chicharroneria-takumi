package pe.edu.cibertec.sw_chicharroneria_takumi.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PromocionesDto {
    private Integer id_promocion;
    private String descripcion_promocion;
    private Integer puntos_necesarios;
    private Double descuento;
}
