package com.tienda.ejercicio_tienda.implementacion;

import com.tienda.ejercicio_tienda.dao.ProductoDAO;
import com.tienda.ejercicio_tienda.entity.Producto;

import java.util.List;

public interface ProductoImpl {
    public List<ProductoDAO> listarTodos();
    public Producto crearProducto(Producto producto);
    public Producto encontrarPorId(Integer id);
    public Producto actualizar(Producto producto);
    public String eliminarPorId(Integer id);
}
