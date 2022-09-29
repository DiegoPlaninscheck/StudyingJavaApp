package br.sc.senai.produtos.model.entities;

public class Venda {
    private Pessoa pessoa;
    private Produto produto;
    private int qtdVendida, numeroVenda;
    private double valorTotal;

    public Venda(Pessoa pessoa, Produto produto, int qtdVendida, int numeroVenda, double valorTotal) {
        this.pessoa = pessoa;
        this.produto = produto;
        this.qtdVendida = qtdVendida;
        this.numeroVenda = numeroVenda;
        this.valorTotal = valorTotal;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQtdVendida() {
        return qtdVendida;
    }

    public void setQtdVendida(int qtdVendida) {
        this.qtdVendida = qtdVendida;
    }

    public int getNumeroVenda() {
        return numeroVenda;
    }

    public void setNumeroVenda(int numeroVenda) {
        this.numeroVenda = numeroVenda;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
