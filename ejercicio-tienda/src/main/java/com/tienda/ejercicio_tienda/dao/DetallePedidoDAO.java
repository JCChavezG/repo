package com.tienda.ejercicio_tienda.dao;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetallePedidoDAO {

    private int id;

    private double cantidad;

    private double precioUnitario;

    private Boolean isActive=true;

    private int id_pedido;

    private int productos_id;
}
