package pe.edu.cibertec.sw_chicharroneria_takumi.service;

import pe.edu.cibertec.sw_chicharroneria_takumi.dto.PromocionesDto;
import pe.edu.cibertec.sw_chicharroneria_takumi.model.cliente.Promociones;

import java.util.List;
import java.util.Optional;

public interface IPromocionesService {
    List<Promociones> listarPromociones();
    Promociones guardarPromocion(Promociones promociones);
    Optional<Promociones> obtenerPromocionesPorId(Integer id_promocion);
    void registrarPromociones(PromocionesDto promocionesDto);
}
