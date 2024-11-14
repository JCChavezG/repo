package com.tienda.ejercicio_tienda.repository;

import com.tienda.ejercicio_tienda.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
}
