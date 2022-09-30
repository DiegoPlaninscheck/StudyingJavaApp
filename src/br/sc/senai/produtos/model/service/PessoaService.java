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

    public void cadastrarPessoa(String nomePessoa, String cpfPessoa, String emailPessoa, String senhaPessoa, int tipoPessoa) {
        try {
           new PessoaDAO().cadastrarPessoa(nomePessoa, cpfPessoa, emailPessoa, senhaPessoa, tipoPessoa);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
