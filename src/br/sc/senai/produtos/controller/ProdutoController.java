package br.sc.senai.produtos.controller;

import br.sc.senai.produtos.model.entities.Produto;
import br.sc.senai.produtos.model.service.ProdutoService;

import java.util.Collection;

public class ProdutoController {

    public Collection<Produto> selecionarTodosProdutos() {
        return new ProdutoService().selecionarTodosProdutos();
    }

    ProdutoService produtoService = new ProdutoService();

    public void cadastrarProduto(String nome, Double valor, Integer qtdEstoque) {
        produtoService.cadastrarProduto(nome, valor, qtdEstoque);
    }

    public Produto selecionarProdutoPorId(int idProduto) {
        return produtoService.selecionarProdutoPorId(idProduto);
    }

    public void venderProduto(Produto produto, Integer qtdProdutoVender) {
        produtoService.venderProduto(produto, qtdProdutoVender);
    }
}
