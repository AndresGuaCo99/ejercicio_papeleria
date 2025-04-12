package com.example.linea3_papeleria.Model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idCliente;

    private String nombre;
    private String cedula;
    private String telefono;
    private String correo;

}

