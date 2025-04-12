package com.example.linea3_papeleria.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idProveedor;
    private String nombre;
    private String telefono;
    private String correo;
    private String direccion;

}
