package pe.edu.cibertec.sw_chicharroneria_takumi.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.sw_chicharroneria_takumi.model.inventario.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    @Transactional
    @Modifying
    @Procedure(procedureName = "InsertarProducto")
    void registrarNuevoProducto(
            @Param("p_nombre_producto") String nombre_producto,
            @Param("p_descripcion") String descripcion,
            @Param("p_id_categoria") Integer categoriaId_categoria
    );
}
