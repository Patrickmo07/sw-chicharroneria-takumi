package pe.edu.cibertec.sw_chicharroneria_takumi.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.sw_chicharroneria_takumi.model.cliente.Clientes;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Integer> {
    @Transactional
    @Modifying
    @Procedure(procedureName = "InsertarCliente")
    void registrarNuevoCliente(
            @Param("p_nombre_cliente") String nombre_cliente,
            @Param("p_telefono_cliente") String telefono_cliente,
            @Param("p_correo_cliente") String correo_cliente,
            @Param("p_puntos_fidelidad") Integer puntos_fidelidad

    );
}
