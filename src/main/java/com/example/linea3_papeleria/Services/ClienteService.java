package com.example.linea3_papeleria.Services;

import com.example.linea3_papeleria.Model.Cliente;
import com.example.linea3_papeleria.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    // Listar todos los clientes
    public List<Cliente> listar() {
        return repository.findAll();
    }

    // Guardar un nuevo cliente
    public Cliente guardar(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("El cliente no puede ser nulo.");
        }
        if (cliente.getNombre() == null || cliente.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre del cliente es obligatorio.");
        }
        if (cliente.getCorreo() == null || cliente.getCorreo().isEmpty()) {
            throw new IllegalArgumentException("El correo del cliente es obligatorio.");
        }

        // Puedes agregar más validaciones según tus reglas

        return repository.save(cliente);
    }

    // Eliminar un cliente por ID
    public void eliminar(Integer id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("No se puede eliminar: cliente con ID " + id + " no existe.");
        }
        repository.deleteById(id);
    }

    // Buscar un cliente por ID
    public Cliente buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado con ID: " + id));
    }

    // Actualizar cliente existente
    public Cliente actualizar(Integer id, Cliente clienteActualizado) {
        return repository.findById(id).map(clienteExistente -> {
            // Actualizar campos necesarios
            clienteExistente.setNombre(clienteActualizado.getNombre());
            clienteExistente.setCorreo(clienteActualizado.getCorreo());
            clienteExistente.setTelefono(clienteActualizado.getTelefono());
           clienteExistente.setCedula(clienteActualizado.getCedula());
            // Agrega más campos si tu clase Cliente los tiene

            return repository.save(clienteExistente);
        }).orElseThrow(() -> new IllegalArgumentException("No se puede actualizar: cliente con ID " + id + " no encontrado."));
    }
}
