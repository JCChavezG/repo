package com.tienda.ejercicio_tienda.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InventarioDAO {


    private int id;


    private int producto_id;


    private double cantidadEnStock;


    private Boolean isActive ;
}
