package com.tienda.ejercicio_tienda.service;

import com.tienda.ejercicio_tienda.dao.PedidoDAO;
import com.tienda.ejercicio_tienda.entity.Pedido;
import com.tienda.ejercicio_tienda.implementacion.PedidoImp;
import com.tienda.ejercicio_tienda.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService implements PedidoImp {

    @Autowired
    PedidoRepository pedidoRepository;

    @Override
    public List<PedidoDAO> listarTodos() {
        List<Pedido>listaPedidos = pedidoRepository.findAll();
        List<PedidoDAO> listaPedidosDao = listaPedidos.stream().map(s->
        {
            PedidoDAO pedidoDAO = new PedidoDAO();
            pedidoDAO.setId(s.getId());
            pedidoDAO.setFechaPedido(s.getFechaPedido());
            pedidoDAO.setTotalPedido(s.getTotalPedido());
            pedidoDAO.setCliente_id(s.getCliente().getId());
            return pedidoDAO;
        }).toList();

        return listaPedidosDao;
    }

    @Override
    public Pedido crearPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido encontarPorId(Integer id) {
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);
        if (pedidoOptional.isPresent()){
            return pedidoOptional.get();
        }else {
            return new Pedido();
        }

    }

    @Override
    public Pedido actualizar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public String eliminar(Integer id) {
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);
        if (pedidoOptional.isPresent()){
            Pedido pedido = pedidoOptional.get();
            pedido.setIsActive(false);
            pedidoRepository.save(pedido);
            return "Pedido eliminado";
        }else{
            return "El pedido no se encuentra";
        }

    }
}
