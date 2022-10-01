package br.sc.senai.produtos.controller;

import br.sc.senai.produtos.model.entities.Pessoa;
import br.sc.senai.produtos.model.entities.Produto;
import br.sc.senai.produtos.model.service.PessoaService;

import java.util.Collection;

public class PessoaController {

    Pessoa model;
    PessoaService pessoaService = new PessoaService();

    public Pessoa validaLogin(String email, String senha) {
        model = pessoaService.validaLogin(email);
        return model.validaLogin(senha);
    }

    public void cadastrarPessoa(String nomePessoa, String cpfPessoa, String emailPessoa, String senhaPessoa, int tipoPessoa) {
        pessoaService.cadastrarPessoa(nomePessoa, cpfPessoa, emailPessoa, senhaPessoa, tipoPessoa);
    }

    public Collection<Pessoa> selecionarTodasPessoas() {
        return pessoaService.selecionarTodasPessoas();
    }

    public Pessoa selecionarPorEmail(String emailPessoa) {
        return pessoaService.selecionarPorEmail(emailPessoa);
    }

    public void editarPessoa(Pessoa pessoaEditar, String nome, String email, String senha) {
        pessoaService.editarPessoa(pessoaEditar, nome, email, senha);
    }

    public void deletarPessoa(Pessoa pessoaEditar) {
        pessoaService.deletarPessoa(pessoaEditar);
    }
}
