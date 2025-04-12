package com.example.linea3_papeleria.Services;

import com.example.linea3_papeleria.Model.Venta;
import com.example.linea3_papeleria.Repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleVentaService {
    @Autowired

    private VentaRepository repository;

    public List<Venta> listar() {
        return repository.findAll();
    }

    public Venta guardar(Venta venta) {
        if (venta == null) {
            throw new IllegalArgumentException("La venta no puede ser nula.");
        }
        if (venta.getFecha() == null) {
            throw new IllegalArgumentException("La fecha de la venta es obligatoria.");
        }

        return repository.save(venta);
    }

    public void eliminar(Integer id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("No se puede eliminar: venta con ID " + id + " no existe.");
        }
        repository.deleteById(id);
    }

    public Venta buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Venta no encontrada con ID: " + id));
    }

    public Venta actualizar(Integer id, Venta ventaActualizada) {
        return repository.findById(id).map(ventaExistente -> {
            // Actualiza los campos necesarios
            ventaExistente.setFecha(ventaActualizada.getFecha());
            ventaExistente.setCliente(ventaActualizada.getCliente());
            // Asegúrate de tener los setters correctos en tu clase Venta

            return repository.save(ventaExistente);
        }).orElseThrow(() -> new IllegalArgumentException("No se puede actualizar: venta con ID " + id + " no encontrada."));
    }
}