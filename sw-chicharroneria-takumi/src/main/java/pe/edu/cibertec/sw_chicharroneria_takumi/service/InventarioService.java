package pe.edu.cibertec.sw_chicharroneria_takumi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.sw_chicharroneria_takumi.dto.CategoriaDto;
import pe.edu.cibertec.sw_chicharroneria_takumi.dto.InventarioDto;
import pe.edu.cibertec.sw_chicharroneria_takumi.dto.ProductoDto;
import pe.edu.cibertec.sw_chicharroneria_takumi.dto.ProveedorDto;
import pe.edu.cibertec.sw_chicharroneria_takumi.model.inventario.Categoria;
import pe.edu.cibertec.sw_chicharroneria_takumi.model.inventario.Inventario;
import pe.edu.cibertec.sw_chicharroneria_takumi.model.inventario.Producto;
import pe.edu.cibertec.sw_chicharroneria_takumi.model.inventario.Proveedor;
import pe.edu.cibertec.sw_chicharroneria_takumi.repository.CategoriaRepository;
import pe.edu.cibertec.sw_chicharroneria_takumi.repository.InventarioRepository;
import pe.edu.cibertec.sw_chicharroneria_takumi.repository.ProductoRepository;
import pe.edu.cibertec.sw_chicharroneria_takumi.repository.ProveedorRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class InventarioService implements IntInventarioService {

    private final InventarioRepository inventarioRepository;
    private final ProductoRepository productoRepository;
    private final ProveedorRepository proveedorRepository;
    private final CategoriaRepository categoriaRepository;

    @Override
    public List<Inventario> listarInventario() {
        return inventarioRepository.findAll();
    }

    @Override
    public void registrarNuevoInventario(InventarioDto inventarioDto) {
        inventarioRepository.registrarNuevoInventario(
                inventarioDto.getProductoId_producto(),
                inventarioDto.getProveedorId_proveedor(),
                inventarioDto.getCantidad(),
                inventarioDto.getTipo_movimiento()
        );
    }

    @Override
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Optional<Producto> obtenerProductoPorId(Integer idprod) {
        Optional<Producto> producto
                = productoRepository.findById(idprod);
        if(producto.isEmpty()){
            return Optional.empty();
        }
        return producto;
    }

    @Override
    public void registrarProducto(ProductoDto productoDto) {
        productoRepository.registrarNuevoProducto(
                productoDto.getNombre_producto(),
                productoDto.getDescripcion(),
                productoDto.getCategoriaId_categoria()
        );
    }

    @Override
    public List<Proveedor> listarProveedores() {
        return proveedorRepository.findAll();
    }

    @Override
    public Proveedor guardarProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    @Override
    public Optional<Proveedor> obtenerProveedorPorId(Integer idprov) {
        Optional<Proveedor> proveedor
                = proveedorRepository.findById(idprov);
        if(proveedor.isEmpty()){
            return Optional.empty();
        }
        return proveedor;
    }

    @Override
    public void registrarProveedor(ProveedorDto proveedorDto) {
        proveedorRepository.registrarNuevoProveedor(
                proveedorDto.getNombre_proveedor(),
                proveedorDto.getContacto_proveedor(),
                proveedorDto.getTelefono_proveedor(),
                proveedorDto.getDireccion_proveedor()
        );
    }

    @Override
    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria guardarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Optional<Categoria> obtenerCategoriaPorId(Integer idcat) {
        Optional<Categoria> categoria
                = categoriaRepository.findById(idcat);
        if(categoria.isEmpty()){
            return Optional.empty();
        }
        return categoria;
    }

    @Override
    public void registrarCategoria(CategoriaDto categoriaDto) {
        categoriaRepository.registrarNuevaCategoria(
                categoriaDto.getNombre_categoria()
        );
    }
}
