package com.tienda.ejercicio_tienda.service;

import com.tienda.ejercicio_tienda.entity.Empleado;
import com.tienda.ejercicio_tienda.implementacion.EmpleadoImp;
import com.tienda.ejercicio_tienda.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService implements EmpleadoImp {

    @Autowired
    EmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> listarTodos() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado crear(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleado encontrarPorId(Integer id) {
        Optional<Empleado> empleadoOptional = empleadoRepository.findById(id);
        if(empleadoOptional.isPresent()){
            return empleadoOptional.get();
        }else {
            return new Empleado();
        }

    }

    @Override
    public Empleado actualizar(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public String deleteById(Integer id) {
        Optional<Empleado> empleadoOptional = empleadoRepository.findById(id);
        if(empleadoOptional.isPresent()){
            Empleado empleado = empleadoOptional.get();
            empleado.setIsActive(false);
            empleadoRepository.save(empleado);
            return "Empleado borrado con exito";
        }else {
            return "El empleado no se ha encontrado";
        }

    }
}
