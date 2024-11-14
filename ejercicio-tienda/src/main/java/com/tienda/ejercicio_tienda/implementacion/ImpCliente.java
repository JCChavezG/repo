package com.tienda.ejercicio_tienda.implementacion;

import com.tienda.ejercicio_tienda.entity.Cliente;
import com.tienda.ejercicio_tienda.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ImpCliente {


    public List<Cliente> listarTodos();
    public Cliente crear(Cliente cliente);
    public Cliente encontrarPorId(Integer id);
    public Cliente actualizar(Cliente cliente);
    public String deleteById(Integer id);



}
