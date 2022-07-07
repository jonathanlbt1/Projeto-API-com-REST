package com.teste.primeiroexemplo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.teste.primeiroexemplo.model.Produto;
import com.teste.primeiroexemplo.model.exception.ResourceNotFoundException;

@Repository
public class ProdutoRepository {

    private ArrayList<Produto> produtos = new ArrayList<Produto>();
    private Integer ultimoId = 0;

    /**
     * Metodo para retornar uma lista de produtos
     * 
     * @return Lista de produtos
     */
    public List<Produto> obterTodos() {
        return produtos;
    }

    /**
     * Metodo que retorna um produto encontrado pelo seu id
     * 
     * @param id Id do produto que sera localizado
     * @return Retorna um produto caso tenha encontrado
     */
    public Optional<Produto> obterPorId(Integer id) {
        return produtos
                .stream()
                .filter(produto -> produto.getId() == id)
                .findFirst();
    }

    /**
     * Metodo para adicionar produto na lista.
     * 
     * @param produto que sera adicionado.
     * @return Retorna produto que foi adicionado na lista.
     */
    public Produto adicionar(Produto produto) {

        ultimoId++;
        produto.setId(ultimoId);
        produtos.add(produto);

        return produto;
    }

    /**
     * Metodo para deletar o produto por id.
     * 
     * @param id do produto a ser deletado.
     */
    public void deletar(Integer id) {
        produtos.removeIf(produto -> produto.getId() == id);
    }

    /**
     * Metodo para atualizar o produto na lista
     * 
     * @param produto que sera atualizado.
     * @return Retorna o produto apos atualizar a lista.
     */
    public Produto atualizar(Produto produto) {
        // Encontrar o produto na lista
        Optional<Produto> produtoEncontrado = obterPorId(produto.getId());
        if (produtoEncontrado.isEmpty()) {
            throw new ResourceNotFoundException("Produto nao pode ser atualizado pois nao existe");
        }

        // Eu tenho que remover o produto da lista
        deletar(produto.getId());

        // Depois adicionar o novo produto.
        // Nao posso usar o metodo adicionar pois se nao vai incrementar o id.

        produtos.add(produto);

        return produto;

    }

}
