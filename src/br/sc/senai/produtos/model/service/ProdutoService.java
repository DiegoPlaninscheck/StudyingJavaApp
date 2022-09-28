package br.sc.senai.produtos.model.service;

import br.sc.senai.produtos.model.dao.ProdutoDAO;
import br.sc.senai.produtos.model.entities.Produto;

import java.util.Collection;

public class ProdutoService {
    public Collection<Produto> selecionarTodosProdutos() {
        return new ProdutoDAO().selecionarTodosProdutos();
    }
}
