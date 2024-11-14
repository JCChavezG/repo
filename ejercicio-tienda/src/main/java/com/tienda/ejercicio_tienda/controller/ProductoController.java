package com.tienda.ejercicio_tienda.controller;

import com.tienda.ejercicio_tienda.dao.ProductoDAO;
import com.tienda.ejercicio_tienda.entity.Producto;
import com.tienda.ejercicio_tienda.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/productos")
    public List<ProductoDAO> getAll(){
        return productoService.listarTodos();
    }

    @PostMapping("/producto")
    public Producto crear(@RequestBody Producto producto){
        return productoService.crearProducto(producto);
    }

    @GetMapping("/producto/{id}")
    public Producto encontrarPorId(@PathVariable Integer id){
        return productoService.encontrarPorId(id);
    }

    @PostMapping("/editar/{id}")
    public Producto actualizar(@RequestBody Producto producto,@PathVariable Integer id){
        producto.setId(id);

       return productoService.actualizar(producto);
    }

    @PutMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id){
        return productoService.eliminarPorId(id);
    }
}
