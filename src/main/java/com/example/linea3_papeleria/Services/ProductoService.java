package com.example.linea3_papeleria.Services;

import com.example.linea3_papeleria.Model.Producto;
import com.example.linea3_papeleria.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository repository;

      public List<Producto> listar() {
        return repository.findAll();
    }

    public Producto guardar(Producto producto) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo.");
        }

        return repository.save(producto);
    }

    public void eliminar(Integer id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("No se puede eliminar: producto con ID " + id + " no existe.");
        }
        repository.deleteById(id);
    }

    public Producto buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con ID: " + id));
    }


    public Producto actualizar(Integer id, Producto productoActualizado) {
        return repository.findById(id).map(productoExistente -> {
            productoExistente.setNombre(productoActualizado.getNombre());
            productoExistente.setDescripcion(productoActualizado.getDescripcion());
            productoExistente.setPrecio(productoActualizado.getPrecio());
            productoExistente.setStock(productoActualizado.getStock());


            return repository.save(productoExistente);
        }).orElseThrow(() -> new IllegalArgumentException("No se puede actualizar: producto con ID " + id + " no encontrado."));
    }
}