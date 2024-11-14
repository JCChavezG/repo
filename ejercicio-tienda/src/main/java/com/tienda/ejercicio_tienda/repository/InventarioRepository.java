package com.tienda.ejercicio_tienda.repository;

import com.tienda.ejercicio_tienda.entity.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioRepository extends JpaRepository<Inventario,Integer> {
}
