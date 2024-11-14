package com.tienda.ejercicio_tienda.service;

import com.tienda.ejercicio_tienda.entity.Cliente;
import com.tienda.ejercicio_tienda.implementacion.ImpCliente;
import com.tienda.ejercicio_tienda.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements ImpCliente {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente crear(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente encontrarPorId(Integer id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if(clienteOptional.isPresent()){
            return clienteOptional.get();
        }else {
            return new Cliente();
        }

    }

    @Override
    public Cliente actualizar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public String deleteById(Integer id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if(clienteOptional.isPresent()){
            Cliente cliente = clienteOptional.get();
            cliente.setIsActive(false);
            clienteRepository.save(cliente);
            return "Cliente borrado con exito";
        }else {
            return "No se ha encontrado el cliente";
        }

    }
}
