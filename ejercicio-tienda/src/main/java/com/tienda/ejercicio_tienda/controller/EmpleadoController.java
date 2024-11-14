package com.tienda.ejercicio_tienda.controller;

import com.tienda.ejercicio_tienda.entity.Empleado;
import com.tienda.ejercicio_tienda.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleado/")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;


    @GetMapping("/empleados")
    public List<Empleado> readAll(){
        return empleadoService.listarTodos().stream().filter(s ->s.getIsActive()).toList();
    }

    @PostMapping("/empleado")
    public Empleado crear(@RequestBody Empleado empleado){

        return  empleadoService.crear(empleado);
    }

    @GetMapping("/empleado/{id}")
    public Empleado buscarPorId(@PathVariable Integer id){
        return empleadoService.encontrarPorId(id);
    }

    @PostMapping("/editar/{id}")
    public Empleado actualizar(@RequestBody Empleado empleado, @PathVariable Integer id){
        empleado.setId(id);

        return empleadoService.actualizar(empleado);
    }

    @PutMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id){
        return  empleadoService.deleteById(id);
    }



}
