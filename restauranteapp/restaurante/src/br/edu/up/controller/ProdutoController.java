package br.edu.up.controller;

import br.edu.up.dao.ProdutoDAO;
import br.edu.up.model.Produto;
import java.util.List;

public class ProdutoController {
    private ProdutoDAO produtoDAO = new ProdutoDAO();

    public void adicionarProduto(Produto produto) {
        produtoDAO.adicionar(produto);
    }

    public Produto buscarProduto(String nome) {
        return produtoDAO.buscar(nome);
    }

    public void atualizarProduto(Produto produto) {
        produtoDAO.atualizar(produto);
    }

    public void removerProduto(String nome) {
        produtoDAO.remover(nome);
    }

    public List<Produto> listarProdutos() {
        return produtoDAO.listar();
    }
}