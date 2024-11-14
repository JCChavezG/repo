package com.tienda.ejercicio_tienda.controller;

import com.tienda.ejercicio_tienda.dao.InventarioDAO;
import com.tienda.ejercicio_tienda.entity.Inventario;
import com.tienda.ejercicio_tienda.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventario/")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @GetMapping("/inventario")
    public List<InventarioDAO> getAll(){
        return inventarioService.listarTodos().stream().filter(s ->s.getIsActive()).toList();
    }

    @PostMapping("/inventario")
    public Inventario crear(@RequestBody Inventario inventario){
        return inventarioService.crear(inventario);
    }

    @GetMapping("/inventario/{id}")
    public Inventario buscarPorId(@PathVariable Integer id){
        return inventarioService.encontrarPorId(id);
    }

    @PostMapping("/editar/{id}")
    public Inventario actualizar(@RequestBody Inventario inventario,@PathVariable Integer id){
        inventario.setId(id);
        return inventarioService.actualizar(inventario);
    }

    @PutMapping("/eliminar/{id}")
    public String eliminarPorId(@PathVariable Integer id){
        return inventarioService.eliminarPorId(id);
    }

}
