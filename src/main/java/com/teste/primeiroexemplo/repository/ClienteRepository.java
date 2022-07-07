package com.teste.primeiroexemplo.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.teste.primeiroexemplo.model.Cliente;

@Repository
public class ClienteRepository {
    
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private Integer id;

    public List<Cliente> obterTodos() {
        return clientes;
    }

    public Optional<Cliente> obterPorId(Integer id) {
        return clientes
                .stream()
                .filter(cliente -> cliente.getId() == id)
                .findFirst();
    }
    
    public Cliente adicionarCliente(Cliente cliente) {
        id++;
        cliente.setId(id);
        clientes.add(cliente);

        return cliente;
    }

    public void deletar(Integer id) {
        clientes.removeIf(cliente -> cliente.getId() == id);
    }

    public Cliente atualizarCliente(Cliente cliente) {

        Optional<Cliente> encontraCliente = obterPorId(cliente.getId());
        if (encontraCliente.isEmpty()) {
            throw new InputMismatchException("Cliente nao encontrado");
        }

        deletar(cliente.getId());
        clientes.add(cliente);

        return cliente;
    }


}
