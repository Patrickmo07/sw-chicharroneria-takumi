package pe.edu.cibertec.sw_chicharroneria_takumi.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.sw_chicharroneria_takumi.model.inventario.Inventario;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Integer> {
    @Transactional
    @Modifying
    @Procedure(procedureName = "InsertarControlInventario")
    void registrarNuevoInventario(
        @Param("p_id_producto") Integer productoId_producto,
        @Param("p_id_proveedor") Integer proveedorId_proveedor,
        @Param("p_cantidad") Integer cantidad,
        @Param("p_tipo_movimiento") String tipo_movimiento
    );
}
