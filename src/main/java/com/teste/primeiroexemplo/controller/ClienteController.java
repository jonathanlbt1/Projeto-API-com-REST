package com.teste.primeiroexemplo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.primeiroexemplo.model.Cliente;
import com.teste.primeiroexemplo.services.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> obterTodos() {
        return clienteService.obterTodos();
    }

    @GetMapping("/{id}")
    public Optional obterPorId(@PathVariable Integer id) {
        return clienteService.obterPorid(id);
    }

    @PostMapping
    public Cliente adicionar(@RequestBody Cliente cliente) {
        return clienteService.adicionar(cliente);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Integer id) {
        clienteService.deletar(id);
        return "Cliente id:" + id + " deletado com sucesso!";
    }

    @PutMapping("/{id}")
    public Cliente atualizar(@RequestBody Cliente cliente, @PathVariable Integer id) {
        return clienteService.atualizar(id, cliente);
    }
}