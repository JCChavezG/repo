package com.tienda.ejercicio_tienda.controller;

import com.tienda.ejercicio_tienda.entity.Proveedor;
import com.tienda.ejercicio_tienda.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedor/")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping("/proveedores")
    public List<Proveedor> readAll(){
        return proveedorService.listarTodos().stream().filter(s -> s.getIsActive()).toList();
    }

    @PostMapping("/proveedor")
    public Proveedor crear(@RequestBody Proveedor proveedor){
        return proveedorService.crear(proveedor);
    }

    @GetMapping("/proveedor/{id}")
    public Proveedor buscarPorId(@PathVariable Integer id){
        return proveedorService.encontrarPorId(id);
    }
    @PostMapping("/editar/{id}")
    public Proveedor actualizar(@RequestBody Proveedor proveedor,@PathVariable Integer id){
        proveedor.setId(id);
        return proveedorService.actualizar(proveedor);
    }
    @PostMapping("/eliminar/{id}")
    public String eliminarPorId(@RequestParam Integer id){
        return proveedorService.deleteById(id);
    }
}
