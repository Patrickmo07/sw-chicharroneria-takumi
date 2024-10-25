package pe.edu.cibertec.sw_chicharroneria_takumi.service;

import pe.edu.cibertec.sw_chicharroneria_takumi.dto.ClientesDto;
import pe.edu.cibertec.sw_chicharroneria_takumi.model.cliente.Clientes;

import java.util.List;
import java.util.Optional;

public interface IClientesService {

    List<Clientes> listarClientes();
    Clientes guardarClientes(Clientes clientes);
    Optional<Clientes> obtenerClientesPorId(Integer id_cliente);
    void registrarClientes(ClientesDto clientesDto);
}
