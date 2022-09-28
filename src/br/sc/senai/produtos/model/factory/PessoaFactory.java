package br.sc.senai.produtos.model.factory;

import br.sc.senai.produtos.model.entities.Cliente;
import br.sc.senai.produtos.model.entities.Funcionario;
import br.sc.senai.produtos.model.entities.Pessoa;

public class PessoaFactory {
    public Pessoa getPessoa(int numero, int tipo, String nome, String cpf, String email, String senha) {
        switch (tipo) {
            case 1 -> {
                return new Funcionario(numero, nome, cpf, email, senha);
            }
            case 2 -> {
                return new Cliente(numero, nome, cpf, email, senha);
            }
            default -> {
                return null;
            }
        }
    }
}
