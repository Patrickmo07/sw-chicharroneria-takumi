package pe.edu.cibertec.sw_chicharroneria_takumi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibertec.sw_chicharroneria_takumi.model.pedidos.DetallePedido;

import java.math.BigDecimal;

@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Integer > {
    @Transactional
    @Modifying
    @Procedure(procedureName = "InsertarDetallePedido")
    void registrarDetallePedido(
            @Param("id_detalle") Integer idDetalle,
            @Param("id_pedido") Integer idPedido,
            @Param("id_producto") Integer idProducto,
            @Param("cantidad") Integer cantidad,
            @Param("precio") BigDecimal precio
            );
}
