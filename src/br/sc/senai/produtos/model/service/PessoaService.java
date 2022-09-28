package br.sc.senai.produtos.model.service;

import br.sc.senai.produtos.model.dao.PessoaDAO;
import br.sc.senai.produtos.model.entities.Pessoa;

public class PessoaService {
    public Pessoa validaLogin(String email) {
        try {
            return new PessoaDAO().buscarPorEmail(email);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
