package pe.edu.cibertec.sw_chicharroneria_takumi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.sw_chicharroneria_takumi.dto.*;
import pe.edu.cibertec.sw_chicharroneria_takumi.exception.ResourceNotFoundException;
import pe.edu.cibertec.sw_chicharroneria_takumi.model.inventario.Categoria;
import pe.edu.cibertec.sw_chicharroneria_takumi.model.inventario.Inventario;
import pe.edu.cibertec.sw_chicharroneria_takumi.model.inventario.Producto;
import pe.edu.cibertec.sw_chicharroneria_takumi.model.inventario.Proveedor;
import pe.edu.cibertec.sw_chicharroneria_takumi.service.IntInventarioService;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/inventario")
public class InventarioController {
    @Autowired
    private final IntInventarioService intInventarioService;

    @GetMapping("/listar")
    public ResponseEntity<List<Inventario>> listarControlesInventario(){
        List<Inventario> inventarioList = new ArrayList<>(intInventarioService.listarInventario());
        if(inventarioList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(inventarioList, HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<GenericResponseDto<String>> registrarNuevoControlInventario(
            @RequestBody InventarioDto inventarioDto
    ){
        try{
            intInventarioService.registrarNuevoInventario(inventarioDto);
            return new ResponseEntity<>(GenericResponseDto.
                    <String>builder().correcto(true)
                    .mensaje("Control de inventario registrado correctamente")
                    .build(), HttpStatus.CREATED);
        }catch (Exception ex){
            return new ResponseEntity<>(GenericResponseDto.
                    <String>builder().correcto(false)
                    .mensaje("Control de inventario no registrado")
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/producto/listar")
    public ResponseEntity<List<Producto>> listarProductos(){
        List<Producto> productoList = new ArrayList<>(intInventarioService.listarProductos());
        if(productoList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(productoList, HttpStatus.OK);
    }

    @PostMapping("/producto/registrar")
    public ResponseEntity<GenericResponseDto<String>> registrarNuevoProducto(
            @RequestBody ProductoDto productoDto
    ){
        try{
            intInventarioService.registrarProducto(productoDto);
            return new ResponseEntity<>(GenericResponseDto.
                    <String>builder().correcto(true)
                    .mensaje("Producto registrado correctamente")
                    .build(), HttpStatus.CREATED);
        }catch (Exception ex){
            return new ResponseEntity<>(GenericResponseDto.
                    <String>builder().correcto(false)
                    .mensaje("Producto no registrado")
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("producto/actualizar/{id}")
    public ResponseEntity<Producto> actualizarProducto(
            @PathVariable Integer id,
            @RequestBody Producto producto
    ){
        Producto nuevoProducto = intInventarioService.obtenerProductoPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El producto con código "
                        + id +" no existe"));
        nuevoProducto.setNombre_producto(producto.getNombre_producto());
        nuevoProducto.setDescripcion(producto.getDescripcion());
        nuevoProducto.setCategoria(producto.getCategoria());
        return new ResponseEntity<>(
                intInventarioService.guardarProducto(nuevoProducto),
                HttpStatus.OK);
    }

    @GetMapping("/proveedor/listar")
    public ResponseEntity<List<Proveedor>> listarProveedores(){
        List<Proveedor> proveedorList = new ArrayList<>(intInventarioService.listarProveedores());
        if(proveedorList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(proveedorList, HttpStatus.OK);
    }

    @PostMapping("/proveedor/registrar")
    public ResponseEntity<GenericResponseDto<String>> registrarNuevoProveedor(
            @RequestBody ProveedorDto proveedorDto
    ){
        try{
            intInventarioService.registrarProveedor(proveedorDto);
            return new ResponseEntity<>(GenericResponseDto.
                    <String>builder().correcto(true)
                    .mensaje("Proveedor registrado correctamente")
                    .build(), HttpStatus.CREATED);
        }catch (Exception ex){
            return new ResponseEntity<>(GenericResponseDto.
                    <String>builder().correcto(false)
                    .mensaje("Proveedor no registrado")
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("proveedor/actualizar/{id}")
    public ResponseEntity<Proveedor> actualizarProveedor(
            @PathVariable Integer id,
            @RequestBody Proveedor proveedor
    ){
        Proveedor nuevoProveedor = intInventarioService.obtenerProveedorPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El proveedor con código "
                        + id +" no existe"));
        nuevoProveedor.setNombre_proveedor(proveedor.getNombre_proveedor());
        nuevoProveedor.setContacto_proveedor(proveedor.getContacto_proveedor());
        nuevoProveedor.setTelefono_proveedor(proveedor.getTelefono_proveedor());
        nuevoProveedor.setDireccion_proveedor(proveedor.getDireccion_proveedor());
        return new ResponseEntity<>(
                intInventarioService.guardarProveedor(nuevoProveedor),
                HttpStatus.OK);
    }

    @GetMapping("/categoria/listar")
    public ResponseEntity<List<Categoria>> listarCategorias(){
        List<Categoria> categoriaList = new ArrayList<>(intInventarioService.listarCategorias());
        if(categoriaList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(categoriaList, HttpStatus.OK);
    }

    @PostMapping("/categoria/registrar")
    public ResponseEntity<GenericResponseDto<String>> registrarNuevaCategoria(
            @RequestBody CategoriaDto categoriaDto
    ){
        try{
            intInventarioService.registrarCategoria(categoriaDto);
            return new ResponseEntity<>(GenericResponseDto.
                    <String>builder().correcto(true)
                    .mensaje("Categoria registrado correctamente")
                    .build(), HttpStatus.CREATED);
        }catch (Exception ex){
            return new ResponseEntity<>(GenericResponseDto.
                    <String>builder().correcto(false)
                    .mensaje("Categoria no registrado")
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("categoria/actualizar/{id}")
    public ResponseEntity<Categoria> actualizarCategoria(
            @PathVariable Integer id,
            @RequestBody Categoria categoria
    ){
        Categoria nuevaCategoria = intInventarioService.obtenerCategoriaPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("La categoria con código "
                        + id +" no existe"));
        nuevaCategoria.setNombre_categoria(categoria.getNombre_categoria());
        return new ResponseEntity<>(
                intInventarioService.guardarCategoria(nuevaCategoria),
                HttpStatus.OK);
    }
}