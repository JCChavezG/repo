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
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private int id;

    @Column(name="nombre")
    private String nombre;

    @Column(name = "apellido" )
    private String apellido;

    @Column(name = "direccion")
    private String direccion;

    @Column(name="email")
    private String email;

    @Column(name="telefono")
    private String telefono;

    @Column(name = "is_active")
    private Boolean isActive=true;
}

