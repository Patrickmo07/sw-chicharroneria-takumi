package pe.edu.cibertec.sw_chicharroneria_takumi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.sw_chicharroneria_takumi.dto.ClientesDto;
import pe.edu.cibertec.sw_chicharroneria_takumi.model.cliente.Clientes;
import pe.edu.cibertec.sw_chicharroneria_takumi.repository.ClientesRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClientesService implements IClientesService {
    private final ClientesRepository clientesRepository;

    @Override
    public List<Clientes> listarClientes() {
        return clientesRepository.findAll();
    }

    @Override
    public Clientes guardarClientes(Clientes clientes) {
        return clientesRepository.save(clientes);
    }

    @Override
    public Optional<Clientes> obtenerClientesPorId(Integer id_cliente) {
        Optional<Clientes> clientes
                = clientesRepository.findById(id_cliente);
        if(clientes.isEmpty()){
            return Optional.empty();
        }
        return clientes;
    }

    @Override
    public void registrarClientes(ClientesDto clientesDto) {
        clientesRepository.registrarNuevoCliente(
                clientesDto.getNombre_cliente(),
                clientesDto.getTelefono_cliente(),
                clientesDto.getCorreo_cliente(),
                clientesDto.getPuntos_fidelidad()
        );
    }
}
