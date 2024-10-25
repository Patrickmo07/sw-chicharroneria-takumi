package pe.edu.cibertec.sw_chicharroneria_takumi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.sw_chicharroneria_takumi.dto.PromocionesDto;
import pe.edu.cibertec.sw_chicharroneria_takumi.model.cliente.Promociones;
import pe.edu.cibertec.sw_chicharroneria_takumi.repository.PromocionesRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PromocionesService implements IPromocionesService {
    private final PromocionesRepository promocionesRepository;

    @Override
    public List<Promociones> listarPromociones() {
        return promocionesRepository.findAll();
    }

    @Override
    public Promociones guardarPromocion(Promociones promociones) {
        return promocionesRepository.save(promociones);
    }

    @Override
    public Optional<Promociones> obtenerPromocionesPorId(Integer id_promocion) {
        Optional<Promociones> promociones
                = promocionesRepository.findById(id_promocion);
        if(promociones.isEmpty()){
            return Optional.empty();
        }
        return promociones;
    }

    @Override
    public void registrarPromociones(PromocionesDto promocionesDto) {
        promocionesRepository.registrarNuevaPromocion(
                promocionesDto.getDescripcion_promocion(),
                promocionesDto.getPuntos_necesarios(),
                promocionesDto.getDescuento()
        );
    }
}
