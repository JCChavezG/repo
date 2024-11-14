package com.tienda.ejercicio_tienda.controller;

import com.tienda.ejercicio_tienda.entity.Cliente;
import com.tienda.ejercicio_tienda.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente/")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public List<Cliente> readAll(){
        return clienteService.listarTodos().stream().filter(s -> s.getIsActive()).toList();
    }

    @PostMapping("/cliente")
    public Cliente crear(@RequestBody Cliente cliente){
        return clienteService.crear(cliente);
    }

    @PostMapping("/editar/{id}")
        public Cliente actualizar(@RequestBody Cliente cliente,@PathVariable Integer id){
        cliente.setId(id);
        return clienteService.actualizar(cliente);
    }

    @GetMapping("/cliente/{id}")
    public Cliente buscarPorId(@PathVariable Integer id){

        return clienteService.encontrarPorId(id);
    }

    @PutMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id){
        return clienteService.deleteById(id);
    }
}
