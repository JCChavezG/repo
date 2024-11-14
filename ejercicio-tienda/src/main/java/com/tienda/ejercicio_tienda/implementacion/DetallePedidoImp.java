package com.tienda.ejercicio_tienda.implementacion;

import com.tienda.ejercicio_tienda.dao.DetallePedidoDAO;
import com.tienda.ejercicio_tienda.entity.DetallePedido;

import java.util.List;

public interface DetallePedidoImp {

    public List<DetallePedidoDAO> ListarTodos();
    public DetallePedido crear(DetallePedido detallePedido);
    public DetallePedido encontrar(Integer id);
    public DetallePedido actualizar(DetallePedido detallePedido);
    public String eliminarPorId(Integer id);
}
