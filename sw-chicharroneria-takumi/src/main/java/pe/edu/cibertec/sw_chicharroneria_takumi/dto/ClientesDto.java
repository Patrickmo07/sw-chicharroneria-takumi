package pe.edu.cibertec.sw_chicharroneria_takumi.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ClientesDto {
    private Integer id_cliente;
    private String nombre_cliente;
    private String telefono_cliente;
    private String correo_cliente;
    private Integer puntos_fidelidad;
}
