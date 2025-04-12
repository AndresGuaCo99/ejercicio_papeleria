package com.example.linea3_papeleria.Services;

import com.example.linea3_papeleria.Model.Proveedor;
import com.example.linea3_papeleria.Repository.ProveedorRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository repository;

     public List<Proveedor> listar() {
        return repository.findAll();
    }

    public Proveedor guardar(Proveedor proveedor) {
        if (proveedor.getNombre() == null || proveedor.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre del proveedor no puede estar vacío.");
        }

        return repository.save(proveedor);
    }

    public void eliminar(Integer id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("El proveedor con ID " + id + " no existe.");
        }
        repository.deleteById(id);
    }

    public Proveedor buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Proveedor no encontrado con ID: " + id));
    }

    public Proveedor actualizar(Integer id, Proveedor proveedorActualizado) {
        return repository.findById(id).map(proveedorExistente -> {
            proveedorExistente.setNombre(proveedorActualizado.getNombre());
            proveedorExistente.setDireccion(proveedorActualizado.getDireccion());
            proveedorExistente.setTelefono(proveedorActualizado.getTelefono());
            proveedorExistente.setCorreo(proveedorActualizado.getCorreo());


            return repository.save(proveedorExistente);
        }
        ).orElseThrow(() -> new IllegalArgumentException("No se puede actualizar: proveedor no encontrado con ID " + id));
    }
}
