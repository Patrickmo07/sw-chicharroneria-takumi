package pe.edu.cibertec.sw_chicharroneria_takumi.service;

import pe.edu.cibertec.sw_chicharroneria_takumi.dto.CategoriaDto;
import pe.edu.cibertec.sw_chicharroneria_takumi.dto.InventarioDto;
import pe.edu.cibertec.sw_chicharroneria_takumi.dto.ProductoDto;
import pe.edu.cibertec.sw_chicharroneria_takumi.dto.ProveedorDto;
import pe.edu.cibertec.sw_chicharroneria_takumi.model.inventario.Categoria;
import pe.edu.cibertec.sw_chicharroneria_takumi.model.inventario.Inventario;
import pe.edu.cibertec.sw_chicharroneria_takumi.model.inventario.Producto;
import pe.edu.cibertec.sw_chicharroneria_takumi.model.inventario.Proveedor;

import java.util.List;
import java.util.Optional;

public interface IntInventarioService {
    List<Inventario> listarInventario();
    void registrarNuevoInventario(InventarioDto inventarioDto);

    List<Producto> listarProductos();
    Producto guardarProducto(Producto producto);
    Optional<Producto> obtenerProductoPorId(Integer idprod);
    void registrarProducto(ProductoDto productoDto);

    List<Proveedor> listarProveedores();
    Proveedor guardarProveedor(Proveedor proveedor);
    Optional<Proveedor> obtenerProveedorPorId(Integer idprov);
    void registrarProveedor(ProveedorDto proveedorDto);

    List<Categoria> listarCategorias();
    Categoria guardarCategoria(Categoria categoria);
    Optional<Categoria> obtenerCategoriaPorId(Integer idcat);
    void registrarCategoria(CategoriaDto categoriaDto);
}
