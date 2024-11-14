package com.tienda.ejercicio_tienda.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "detalle_pedido")
public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detalle_pedido_id")
    private int id;

    @Column(name = "cantidad")
    private double cantidad;

    @Column(name = "precio_unitario")
    private double precioUnitario;

    @Column(name = "is_active")
    private Boolean isActive=true;

    @OneToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="producto_id")
    private Producto productos;
}
