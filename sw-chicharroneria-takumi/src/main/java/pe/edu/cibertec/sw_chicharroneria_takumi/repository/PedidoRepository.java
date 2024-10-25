package pe.edu.cibertec.sw_chicharroneria_takumi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.sw_chicharroneria_takumi.model.pedidos.Pedido;

import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

@Query(value = "SELECT p FROM Pedido p WHERE p.tipo_entrega=:tipo_entrega ")
    Optional<Pedido> findByPedidoandtipo(@Param("tipo_entrega") Boolean tipoEntrega );

}
