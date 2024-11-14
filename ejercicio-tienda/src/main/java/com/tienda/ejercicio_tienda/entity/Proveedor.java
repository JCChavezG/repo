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
@Table(name = "proveedores")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "proveedor_id")
    private int id;

    @Column(name = "empresa")
    private String nombreDeLaEmpresa;

    @Column(name = "contacto")
    private String contacto;

    @Column(name="email")
    private String email;

    @Column(name="telefono")
    private String telefono;

    @Column(name = "is_active")
    private Boolean isActive= true;
}
