package br.sc.senai.produtos.controller;

import br.sc.senai.produtos.model.entities.Produto;
import br.sc.senai.produtos.model.service.ProdutoService;

import java.util.Collection;

public class ProdutoController {
    public Collection<Produto> selecionarTodosProdutos() {
        return new ProdutoService().selecionarTodosProdutos();
    }

    public void cadastrarProduto() {

    }
}