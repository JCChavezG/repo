package com.tienda.ejercicio_tienda.repository;

import com.tienda.ejercicio_tienda.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido,Integer> {
}
