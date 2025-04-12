package com.example.linea3_papeleria.Repository;

import com.example.linea3_papeleria.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer> {

    @Query(value = "SELECT * FROM producto WHERE id_proveedor = :idProveedor", nativeQuery = true)
    List<Producto> findProductosByProveedor(@Param("idProveedor") Integer idProveedor);
}
