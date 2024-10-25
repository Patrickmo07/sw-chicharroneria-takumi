package pe.edu.cibertec.sw_chicharroneria_takumi.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.sw_chicharroneria_takumi.model.inventario.Proveedor;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
    @Transactional
    @Modifying
    @Procedure(procedureName = "InsertarProveedor")
    void registrarNuevoProveedor(
            @Param("p_nombre_proveedor") String nombre_proveedor,
            @Param("p_contacto_proveedor") String contacto_proveedor,
            @Param("p_telefono_proveedor") String telefono_proveedor,
            @Param("p_direccion_proveedor") String direccion_proveedor
    );
}
