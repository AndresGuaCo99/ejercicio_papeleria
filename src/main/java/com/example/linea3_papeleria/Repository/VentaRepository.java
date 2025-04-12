package com.example.linea3_papeleria.Repository;

import com.example.linea3_papeleria.Model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {

    @Query(value = "SELECT * FROM venta WHERE id_empleado = :idEmpleado AND id_cliente = :idCliente", nativeQuery = true)
    List<Venta> findVentasByEmpleadoAndCliente(@Param("idEmpleado") Integer idEmpleado, @Param("idCliente") Integer idCliente);

}
