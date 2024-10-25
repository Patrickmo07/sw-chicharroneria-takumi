package pe.edu.cibertec.sw_chicharroneria_takumi.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.sw_chicharroneria_takumi.dto.ClientesDto;
import pe.edu.cibertec.sw_chicharroneria_takumi.dto.GenericResponseDto;
import pe.edu.cibertec.sw_chicharroneria_takumi.exception.ResourceNotFoundException;
import pe.edu.cibertec.sw_chicharroneria_takumi.model.cliente.Clientes;
import pe.edu.cibertec.sw_chicharroneria_takumi.service.IClientesService;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/clientes")
public class ClientesController {
    @Autowired
    private final IClientesService iClientesService;

    @GetMapping("/listar")
    public ResponseEntity<List<Clientes>> listarClientes(){
        List<Clientes> clientesList = new ArrayList<>(iClientesService.listarClientes());
        if(clientesList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(clientesList, HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<GenericResponseDto<String>> registrarNuevoCliente(
            @RequestBody ClientesDto clientesDto
    ){
        try{
            iClientesService.registrarClientes(clientesDto);
            return new ResponseEntity<>(GenericResponseDto.
                    <String>builder().correcto(true)
                    .mensaje("Cliente registrado correctamente")
                    .build(), HttpStatus.CREATED);
        }catch (Exception ex){
            return new ResponseEntity<>(GenericResponseDto.
                    <String>builder().correcto(false)
                    .mensaje("Cliente no registrado")
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("actualizar/{id}")
    public ResponseEntity<Clientes> actualizarCliente(
            @PathVariable Integer id,
            @RequestBody Clientes clientes
    ){
        Clientes nuevoCliente = iClientesService.obtenerClientesPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El cliente con código "
                        + id +" no existe"));
        nuevoCliente.setNombre_cliente(clientes.getNombre_cliente());
        nuevoCliente.setTelefono_cliente(clientes.getTelefono_cliente());
        nuevoCliente.setCorreo_cliente(clientes.getCorreo_cliente());
        nuevoCliente.setPuntos_fidelidad(clientes.getPuntos_fidelidad());
        return new ResponseEntity<>(
                iClientesService.guardarClientes(nuevoCliente),
                HttpStatus.OK);
    }

}
