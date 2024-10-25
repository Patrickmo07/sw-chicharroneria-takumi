package pe.edu.cibertec.sw_chicharroneria_takumi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.sw_chicharroneria_takumi.dto.PedidoDto;
import pe.edu.cibertec.sw_chicharroneria_takumi.model.pedidos.Pedido;
import pe.edu.cibertec.sw_chicharroneria_takumi.service.IPedidoService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(path="api/pedido")

public class PedidoController {

    private final IPedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Pedido> registarPedido(@RequestBody PedidoDto pedidoDto) {
        Pedido nuevoPedido = pedidoService.registarPedido(pedidoDto);
        return new ResponseEntity<>(nuevoPedido, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> guardarPedido(@PathVariable Integer id, @RequestBody Pedido pedido) {
        Pedido pedidoActualizado = pedidoService.guardarPedido(pedido);
        return new ResponseEntity<>(pedidoActualizado, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> obtnPedidos() {
        List<Pedido> pedidos = pedidoService.obtnPedidos();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    @GetMapping("/{id}")

    public ResponseEntity<Pedido> obtnPedido(@PathVariable Integer id) {
        Optional<Pedido> pedido = pedidoService.obtnPedido(id);
        return pedido.map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/tipo/{tipo_entrega}")
    public ResponseEntity<Pedido> obtnPedidoXTipo(@PathVariable Boolean tipo_entrega) {
        Optional<Pedido> pedido = pedidoService.obtnPedidoXTipo(tipo_entrega);
        return pedido.map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }



}
