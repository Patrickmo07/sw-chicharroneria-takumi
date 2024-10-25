package pe.edu.cibertec.sw_chicharroneria_takumi.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.sw_chicharroneria_takumi.model.cliente.Promociones;

@Repository
public interface PromocionesRepository extends JpaRepository<Promociones, Integer> {
    @Transactional
    @Modifying
    @Procedure(procedureName = "InsertarPromocion")
    void registrarNuevaPromocion(
            @Param("p_descripcion_promocion") String descripcion_promocion,
            @Param("p_puntos_necesarios") Integer puntos_necesarios,
            @Param("p_descuento") Double descuento);
}
