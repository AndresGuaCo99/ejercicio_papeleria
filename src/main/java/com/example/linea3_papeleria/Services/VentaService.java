package com.example.linea3_papeleria.Services;

import com.example.linea3_papeleria.Model.Venta;
import com.example.linea3_papeleria.Repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VentaService {

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

        if (venta.getCliente() == null) {
            throw new IllegalArgumentException("Debe especificarse un cliente para la venta.");
        }

        return repository.save(venta);
    }

    public void eliminar(Integer id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("No se puede eliminar: la venta con ID " + id + " no existe.");
        }
        repository.deleteById(id);
    }

    public Venta buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Venta no encontrada con ID: " + id));
    }

    public Venta actualizar(Integer id, Venta ventaActualizada) {
        return repository.findById(id).map(ventaExistente -> {
            ventaExistente.setFecha(ventaActualizada.getFecha());
            ventaExistente.setCliente(ventaActualizada.getCliente());

            return repository.save(ventaExistente);
        }).orElseThrow(() -> new IllegalArgumentException("No se puede actualizar: venta con ID " + id + " no encontrada."));

    }
}