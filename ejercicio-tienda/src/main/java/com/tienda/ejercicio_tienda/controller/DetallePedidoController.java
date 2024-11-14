package com.tienda.ejercicio_tienda.controller;

import com.tienda.ejercicio_tienda.dao.DetallePedidoDAO;
import com.tienda.ejercicio_tienda.entity.DetallePedido;
import com.tienda.ejercicio_tienda.service.DetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detallePedido")
public class DetallePedidoController {

    @Autowired
    private DetallePedidoService detallePedidoService;

    @GetMapping("/detallePedidos")
    public List<DetallePedidoDAO> getAll(){
        return detallePedidoService.ListarTodos().stream().filter(s->s.getIsActive()).toList();
    }

    @PostMapping("/detallePedido")
    public DetallePedido crear(@RequestBody DetallePedido detallePedido){
        return detallePedidoService.crear(detallePedido);
    }

    @GetMapping("/detallePedido/{id}")
    public DetallePedido encontarPorId(@PathVariable Integer id){
        return detallePedidoService.encontrar(id);
    }

    @PostMapping("/detallePedido/{id}")
    public DetallePedido editar(@RequestBody DetallePedido detallePedido, @PathVariable Integer id){
        detallePedido.setId(id);
        return detallePedidoService.actualizar(detallePedido);
    }

    @PutMapping("/eliminar/{id}")
    public String eliminarPorId(@PathVariable Integer id){
        return detallePedidoService.eliminarPorId(id);
    }
}
