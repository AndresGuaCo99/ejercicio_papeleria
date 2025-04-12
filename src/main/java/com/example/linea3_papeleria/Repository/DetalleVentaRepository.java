package com.example.linea3_papeleria.Repository;

import com.example.linea3_papeleria.Model.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVenta,Integer> {


    @Query(value = "SELECT dv.* FROM detalle_venta dv " +
            "JOIN venta v ON dv.id_venta = v.id_venta " +
            "WHERE v.id_empleado = :idEmpleado AND v.id_cliente = :idCliente", nativeQuery = true)
    List<DetalleVenta> findDetallesByEmpleadoAndCliente(@Param("idEmpleado") Integer idEmpleado, @Param("idCliente") Integer idCliente);
}
