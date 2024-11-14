package com.tienda.ejercicio_tienda.implementacion;

import com.tienda.ejercicio_tienda.dao.InventarioDAO;
import com.tienda.ejercicio_tienda.entity.Inventario;

import java.util.List;

public interface InventarioImp {

    public List<InventarioDAO> listarTodos();
    public Inventario crear(Inventario inventario);
    public Inventario encontrarPorId(Integer id);
    public Inventario actualizar(Inventario inventario);
    public String eliminarPorId(Integer id);
}
