package com.tienda.ejercicio_tienda.service;

import com.tienda.ejercicio_tienda.dao.DetallePedidoDAO;
import com.tienda.ejercicio_tienda.entity.DetallePedido;
import com.tienda.ejercicio_tienda.implementacion.DetallePedidoImp;
import com.tienda.ejercicio_tienda.repository.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetallePedidoService implements DetallePedidoImp {

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    @Override
    public List<DetallePedidoDAO> ListarTodos() {
        List<DetallePedido>detallePedidos = detallePedidoRepository.findAll();
        List<DetallePedidoDAO>listaPedidos = detallePedidos.stream().map(s->{
            DetallePedidoDAO detallePedidoDAO = new DetallePedidoDAO();
            detallePedidoDAO.setId(s.getId());
            detallePedidoDAO.setIsActive(s.getIsActive());
            detallePedidoDAO.setProductos_id(s.getProductos().getId());
            detallePedidoDAO.setId_pedido(s.getPedido().getId());
            detallePedidoDAO.setCantidad(s.getCantidad());
            detallePedidoDAO.setPrecioUnitario(s.getPrecioUnitario());
            return detallePedidoDAO;
        }).toList();

        return listaPedidos;
    }

    @Override
    public DetallePedido crear(DetallePedido detallePedido) {
        return detallePedidoRepository.save(detallePedido);
    }

    @Override
    public DetallePedido encontrar(Integer id) {
        Optional<DetallePedido> detallePedidoOptional = detallePedidoRepository.findById(id);
        if(detallePedidoOptional.isPresent()){
            return detallePedidoOptional.get();
        }else {
            return new DetallePedido();
        }

    }

    @Override
    public DetallePedido actualizar(DetallePedido detallePedido) {
        return detallePedidoRepository.save(detallePedido);
    }

    @Override
    public String eliminarPorId(Integer id) {
        Optional<DetallePedido>detallePedidoOptional = detallePedidoRepository.findById(id);
        if (detallePedidoOptional.isPresent()){
            DetallePedido detallePedido = detallePedidoOptional.get();
            detallePedido.setIsActive(true);
            detallePedidoRepository.save(detallePedido);
            return "Se ha eliminado el detalle del pedido";
        }else {
            return "No se ha encontrado el detalle del pedido";
        }

    }
}
