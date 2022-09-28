package br.sc.senai.produtos.model.entities;

public class Produto {
    private int numeroProduto, qtdEstoque;
    private double valorProduto;
    private String nomeProduto;

    public Produto(int numeroProduto, int qtdEstoque, double valorProduto, String nomeProduto) {
        this.numeroProduto = numeroProduto;
        this.qtdEstoque = qtdEstoque;
        this.valorProduto = valorProduto;
        this.nomeProduto = nomeProduto;
    }

    public int getNumeroProduto() {
        return numeroProduto;
    }

    public void setNumeroProduto(int numeroProduto) {
        this.numeroProduto = numeroProduto;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
}
