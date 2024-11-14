package com.tienda.ejercicio_tienda.implementacion;


import com.tienda.ejercicio_tienda.entity.Proveedor;

import java.util.List;

public interface ProveedorImp {

    public List<Proveedor> listarTodos();
    public Proveedor crear(Proveedor proveedor);
    public Proveedor encontrarPorId(Integer id);
    public Proveedor actualizar(Proveedor proveedor);
    public String deleteById(Integer id);
}
