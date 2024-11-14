package com.tienda.ejercicio_tienda.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDAO {

    private int id;
    private String  nombreProducto;
    private String descripcionProducto;
    private double precio;
    private String categoria;
    private String stock;
    private int proveedor_id;
}
