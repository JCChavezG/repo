package com.tienda.ejercicio_tienda.service;

import com.tienda.ejercicio_tienda.dao.ProductoDAO;
import com.tienda.ejercicio_tienda.entity.Producto;
import com.tienda.ejercicio_tienda.implementacion.ProductoImpl;
import com.tienda.ejercicio_tienda.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements ProductoImpl {
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<ProductoDAO> listarTodos() {
        List<Producto> listaProductos = productoRepository.findAll();
        List<ProductoDAO>listaProductosDAO = listaProductos.stream().map(s->
        {
            ProductoDAO productoDAO = new ProductoDAO();
            productoDAO.setId(s.getId());
            productoDAO.setNombreProducto(s.getNombreProducto());
            productoDAO.setCategoria(s.getCategoria());
            productoDAO.setDescripcionProducto(s.getDescripcionProducto());
            productoDAO.setPrecio(s.getPrecio());
            productoDAO.setStock(s.getStock());
            productoDAO.setProveedor_id(s.getProveedor().getId());
            return productoDAO;
        }).toList();
        return listaProductosDAO;
    }

    @Override
    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto encontrarPorId(Integer id) {
        Optional<Producto> productoOptional = productoRepository.findById(id);
        if(productoOptional.isPresent()){
            return productoOptional.get();
        }else {
            return new Producto();
        }

    }

    @Override
    public Producto actualizar(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public String eliminarPorId(Integer id) {
        Optional<Producto> productoOptional = productoRepository.findById(id);
        if (productoOptional.isPresent()){
            Producto producto = productoOptional.get();
            producto.setIsActive(false);
            productoRepository.save(producto);
            return "El producto ha sido eliminado";
        }else{
            return "No se ha encontrado el producto";
        }

    }
}
