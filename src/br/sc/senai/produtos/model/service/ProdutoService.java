package br.sc.senai.produtos.model.service;

import br.sc.senai.produtos.model.dao.ProdutoDAO;
import br.sc.senai.produtos.model.entities.Produto;

import java.util.Collection;

public class ProdutoService {
    public Collection<Produto> selecionarTodosProdutos() {
        return new ProdutoDAO().selecionarTodosProdutos();
    }

    public void cadastrarProduto(String nome, Double valor, Integer qtdEstoque) {
        new ProdutoDAO().cadastrarProduto(nome, valor, qtdEstoque);
    }

    public Produto selecionarProdutoPorId(int idProduto) {
        return new ProdutoDAO().selecionarProdutoPorId(idProduto);
    }
}
