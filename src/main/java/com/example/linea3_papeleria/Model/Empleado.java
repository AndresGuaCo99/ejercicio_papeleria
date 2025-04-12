package com.example.linea3_papeleria.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idEmpleado;
    private String nombre;
    private String cargo;
    private String telefono;

}
