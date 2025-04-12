package com.example.linea3_papeleria.Repository;

import com.example.linea3_papeleria.Model.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVenta,Integer> {
}
