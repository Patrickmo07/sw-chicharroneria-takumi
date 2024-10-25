package pe.edu.cibertec.sw_chicharroneria_takumi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.sw_chicharroneria_takumi.dto.GenericResponseDto;
import pe.edu.cibertec.sw_chicharroneria_takumi.dto.PromocionesDto;
import pe.edu.cibertec.sw_chicharroneria_takumi.exception.ResourceNotFoundException;
import pe.edu.cibertec.sw_chicharroneria_takumi.model.cliente.Promociones;
import pe.edu.cibertec.sw_chicharroneria_takumi.service.IPromocionesService;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/promociones")
public class PromocionesController {
    @Autowired
    private final IPromocionesService iPromocionesService;

    @GetMapping("/listar")
    public ResponseEntity<List<Promociones>> listarPromociones(){
        List<Promociones> promocionesList = new ArrayList<>(iPromocionesService.listarPromociones());
        if(promocionesList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(promocionesList, HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<GenericResponseDto<String>> registrarNuevaPromocion(
            @RequestBody PromocionesDto promocionesDto
    ){
        try{
            iPromocionesService.registrarPromociones(promocionesDto);
            return new ResponseEntity<>(GenericResponseDto.
                    <String>builder().correcto(true)
                    .mensaje("Promocion registrada correctamente")
                    .build(), HttpStatus.CREATED);
        }catch (Exception ex){
            return new ResponseEntity<>(GenericResponseDto.
                    <String>builder().correcto(false)
                    .mensaje("Promocion no registrada")
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("actualizar/{id}")
    public ResponseEntity<Promociones> actualizarPromocion(
            @PathVariable Integer id,
            @RequestBody Promociones promociones
    ){
        Promociones nuevaPromocion = iPromocionesService.obtenerPromocionesPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("La promoción con código "
                        + id +" no existe"));
        nuevaPromocion.setDescripcion_promocion(promociones.getDescripcion_promocion());
        nuevaPromocion.setPuntos_necesarios(promociones.getPuntos_necesarios());
        nuevaPromocion.setDescuento(promociones.getDescuento());
        return new ResponseEntity<>(
                iPromocionesService.guardarPromocion(nuevaPromocion),
                HttpStatus.OK);
    }
}
