package br.sc.senai.produtos.controller;

import br.sc.senai.produtos.model.entities.Pessoa;
import br.sc.senai.produtos.model.service.PessoaService;

public class PessoaController {

    Pessoa model;

    public Pessoa validaLogin(String email, String senha) {
        PessoaService pessoaService = new PessoaService();
        model = pessoaService.validaLogin(email);
        return model.validaLogin(senha);
    }
}
