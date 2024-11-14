package com.tienda.ejercicio_tienda.implementacion;

import com.tienda.ejercicio_tienda.dao.PedidoDAO;
import com.tienda.ejercicio_tienda.entity.Pedido;

import java.util.List;

public interface PedidoImp {

    public List<PedidoDAO> listarTodos();
    public Pedido crearPedido(Pedido pedido);
    public Pedido encontarPorId(Integer id);
    public Pedido actualizar(Pedido pedido);
    public String eliminar(Integer id);
}
