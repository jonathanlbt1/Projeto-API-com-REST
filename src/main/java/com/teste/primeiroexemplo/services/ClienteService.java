package com.teste.primeiroexemplo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.primeiroexemplo.model.Cliente;
import com.teste.primeiroexemplo.repository.ClienteRepository;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> obterTodos() {

        return clienteRepository.obterTodos();
    }

    public Optional<Cliente> obterPorid(Integer id) {
        return clienteRepository.obterPorId(id);
    }

    public Cliente adicionar(Cliente cliente) {
        return clienteRepository.adicionarCliente(cliente);
    }

    public void deletar(Integer id) {
        clienteRepository.deletar(id);
    }

    public Cliente atualizar(Integer id, Cliente cliente) {
        cliente.setId(id);
        
        return clienteRepository.atualizarCliente(cliente);
    }

}
