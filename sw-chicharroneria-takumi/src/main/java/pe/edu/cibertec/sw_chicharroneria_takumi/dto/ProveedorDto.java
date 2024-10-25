package pe.edu.cibertec.sw_chicharroneria_takumi.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProveedorDto {
    private Integer id_proveedor;
    private String nombre_proveedor;
    private String contacto_proveedor;
    private String telefono_proveedor;
    private String direccion_proveedor;
}
