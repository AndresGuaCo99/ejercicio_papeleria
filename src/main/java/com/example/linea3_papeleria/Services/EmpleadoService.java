package com.example.linea3_papeleria.Services;

import com.example.linea3_papeleria.Model.Empleado;
import com.example.linea3_papeleria.Repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {
    @Autowired
    private EmpleadoRepository repository;

    public List<Empleado> listar() {
        return repository.findAll();
    }

    public Empleado guardar(Empleado empleado) {
        if (empleado == null) {
            throw new IllegalArgumentException("El empleado no puede ser nulo.");
        }
        if (empleado.getNombre() == null || empleado.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre del empleado es obligatorio.");
        }

        return repository.save(empleado);
    }

    public void eliminar(Integer id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("No se puede eliminar: empleado con ID " + id + " no existe.");
        }
        repository.deleteById(id);
    }

    public Empleado buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Empleado no encontrado con ID: " + id));
    }

    public Empleado actualizar(Integer id, Empleado empleadoActualizado) {
        return repository.findById(id).map(empleadoExistente -> {
            empleadoExistente.setNombre(empleadoActualizado.getNombre());
            empleadoExistente.setCargo(empleadoActualizado.getCargo());
            empleadoExistente.setTelefono(empleadoActualizado.getTelefono());

            return repository.save(empleadoExistente);
        }).orElseThrow(() -> new IllegalArgumentException("No se puede actualizar: empleado con ID " + id + " no encontrado."));

    }
}