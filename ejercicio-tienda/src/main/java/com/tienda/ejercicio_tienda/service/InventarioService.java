package com.tienda.ejercicio_tienda.service;

import com.tienda.ejercicio_tienda.dao.InventarioDAO;
import com.tienda.ejercicio_tienda.entity.Inventario;
import com.tienda.ejercicio_tienda.implementacion.InventarioImp;
import com.tienda.ejercicio_tienda.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventarioService implements InventarioImp {

    @Autowired
    InventarioRepository inventarioRepository;

    @Override
    public List<InventarioDAO> listarTodos() {
        List<Inventario> inventario = inventarioRepository.findAll();
        List<InventarioDAO> listaInventario = inventario.stream().map(s->{
            InventarioDAO lista = new InventarioDAO();
            lista.setId(s.getId());
            lista.setIsActive(s.getIsActive());
            lista.setCantidadEnStock(s.getCantidadEnStock());
            lista.setProducto_id(s.getProducto().getId());
            return lista;
        }).toList();
        return listaInventario;
    }

    @Override
    public Inventario crear(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    @Override
    public Inventario encontrarPorId(Integer id) {
        Optional<Inventario> inventarioOptional= inventarioRepository.findById(id);
        if(inventarioOptional.isPresent()){
            return  inventarioOptional.get();
        }else {
            return new Inventario();
        }

    }

    @Override
    public Inventario actualizar(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    @Override
    public String eliminarPorId(Integer id) {
        Optional<Inventario> inventarioOptional = inventarioRepository.findById(id);
        if(inventarioOptional.isPresent()){
            Inventario inventario = inventarioOptional.get();
            inventario.setIsActive(false);
            inventarioRepository.save(inventario);
            return "El inventario se ha eliminado con exito";
        }else{
            return "El inventario no se encuentra";
        }

    }
}
