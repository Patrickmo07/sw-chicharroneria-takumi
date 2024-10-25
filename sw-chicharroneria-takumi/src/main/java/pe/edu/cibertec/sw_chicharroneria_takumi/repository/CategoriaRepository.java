package pe.edu.cibertec.sw_chicharroneria_takumi.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.sw_chicharroneria_takumi.model.inventario.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    @Transactional
    @Modifying
    @Procedure(procedureName = "InsertarCategoria")
    void registrarNuevaCategoria(
            @Param("p_nombre_categoria") String p_nombre_categoria
    );
}
