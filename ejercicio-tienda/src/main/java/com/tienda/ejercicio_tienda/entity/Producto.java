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
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "producto_id")
    private int id;

    @Column(name = "nombre_producto")
    private String nombreProducto;

    @Column(name = "descripcion_producto")
    private  String descripcionProducto;

    @Column(name="precio")
    private double precio;

    @Column(name="categoria")
    private String categoria;

    @Column(name = "stock")
    private String stock;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="proveedor_id")
    private Proveedor proveedor;
}
