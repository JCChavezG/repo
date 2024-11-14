package com.tienda.ejercicio_tienda.implementacion;

import com.tienda.ejercicio_tienda.entity.Cliente;
import com.tienda.ejercicio_tienda.entity.Empleado;

import java.util.List;

public interface EmpleadoImp {


    public List<Empleado> listarTodos();
    public Empleado crear(Empleado empleado);
    public Empleado encontrarPorId(Integer id);
    public Empleado actualizar(Empleado empleado);
    public String deleteById(Integer id);
}
