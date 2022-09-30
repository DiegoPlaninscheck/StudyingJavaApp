package br.sc.senai.produtos.view;

import br.sc.senai.produtos.controller.PessoaController;
import br.sc.senai.produtos.model.entities.Funcionario;
import br.sc.senai.produtos.model.entities.Gerente;
import br.sc.senai.produtos.model.entities.Pessoa;

import javax.swing.*;

public class CadastrarPessoa extends JFrame {
    private JButton cadastrarButton;
    private JButton voltarButton;
    private JTextField nome;
    private JTextField cpf;
    private JTextField email;
    private JPasswordField senha;
    private JPanel cadastrarPessoa;

    Pessoa usuario;
    PessoaController pessoaController = new PessoaController();

    public CadastrarPessoa(Pessoa pessoa) {
        criarComponenentes();
        usuario = pessoa;
        voltarButton.addActionListener(e -> {
            dispose();
            new Menu(usuario);
        });
        cadastrarButton.addActionListener(e -> {
            int tipoPessoa;
            if (usuario instanceof Funcionario) {
                tipoPessoa = 2;
                pessoaController.cadastrarPessoa(nome.getText(), cpf.getText(), email.getText(), senha.getText(), tipoPessoa);
            } else if (usuario instanceof Gerente) {
                tipoPessoa = 1;
                pessoaController.cadastrarPessoa(nome.getText(), cpf.getText(), email.getText(), senha.getText(), tipoPessoa);
            }
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
            dispose();
            new Menu(usuario);
        });
    }

    private void criarComponenentes() {
        setContentPane(cadastrarPessoa);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
