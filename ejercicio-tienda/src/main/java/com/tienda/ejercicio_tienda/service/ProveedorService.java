package com.tienda.ejercicio_tienda.service;

import com.tienda.ejercicio_tienda.entity.Proveedor;
import com.tienda.ejercicio_tienda.implementacion.ProveedorImp;
import com.tienda.ejercicio_tienda.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService implements ProveedorImp {

    @Autowired
    ProveedorRepository proveedorRepository;

    @Override
    public List<Proveedor> listarTodos() {
        return proveedorRepository.findAll();
    }

    @Override
    public Proveedor crear(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    @Override
    public Proveedor encontrarPorId(Integer id) {
        Optional<Proveedor> optionalProveedor = proveedorRepository.findById(id);
        if (optionalProveedor.isPresent()){
            return optionalProveedor.get();
        }else{
            return new Proveedor();
        }


    }

    @Override
    public Proveedor actualizar(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    @Override
    public String deleteById(Integer id) {
        Optional<Proveedor>proveedorOptional= proveedorRepository.findById(id);
        if(proveedorOptional.isPresent()){
            Proveedor proveedor = proveedorOptional.get();
            proveedor.setIsActive(false);
            proveedorRepository.save(proveedor);
            return "Proveedor eliminado con exito";
        }else {
            return "EL proveedor no se encuentra";
        }

    }
}
