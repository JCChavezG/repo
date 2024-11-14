package com.tienda.ejercicio_tienda.repository;

import com.tienda.ejercicio_tienda.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,Integer> {
}
