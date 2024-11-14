package com.tienda.ejercicio_tienda.controller;

import com.tienda.ejercicio_tienda.dao.PedidoDAO;
import com.tienda.ejercicio_tienda.entity.Pedido;
import com.tienda.ejercicio_tienda.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedido/")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;


    @GetMapping("/pedidos")
    public List<PedidoDAO> getAll(){
        return pedidoService.listarTodos();
    }

    @PostMapping("/crear")
    public Pedido crear(@RequestBody Pedido pedido){
        return pedidoService.crearPedido(pedido);
    }

    @GetMapping("/pedido/{id}")
    public Pedido encontrarPorId(@RequestParam Integer id){
        return pedidoService.encontarPorId(id);
    }

    @PutMapping("/editar/{id}")
    public Pedido actualizar(@RequestBody Pedido pedido, @PathVariable Integer id){
        pedido.setId(id);
        return pedidoService.actualizar(pedido);
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id){
        return  pedidoService.eliminar(id);
    }
}
