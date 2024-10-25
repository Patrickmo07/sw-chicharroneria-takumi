package pe.edu.cibertec.sw_chicharroneria_takumi.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class InventarioDto {
    private Integer id_inventario;
    private Integer productoId_producto;
    private Integer proveedorId_proveedor;
    private Integer cantidad;
    private String tipo_movimiento;
}
