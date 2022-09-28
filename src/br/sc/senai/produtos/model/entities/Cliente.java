package br.sc.senai.produtos.model.entities;

public class Cliente extends Pessoa{

    public Cliente(int numeroPessoa, String nomePessoa, String cpfPessoa, String emailPessoa, String senhaPessoa) {
        super(numeroPessoa, nomePessoa, cpfPessoa, emailPessoa, senhaPessoa);
    }
}
