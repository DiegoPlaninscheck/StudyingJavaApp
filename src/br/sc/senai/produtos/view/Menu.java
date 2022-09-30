package br.sc.senai.produtos.view;

import br.sc.senai.produtos.model.entities.Pessoa;

import javax.swing.*;

public class Menu extends JFrame {
    private JButton cadastrarPessoaButton;
    private JButton listarProdutosButton;
    private JPanel menu;
    private JButton sairButton;

    Pessoa usuario;

    public Menu(Pessoa pessoa) {
        usuario = pessoa;
        criarComponenetes();
        sairButton.addActionListener(e -> {
            dispose();
            new Login();
        });
        listarProdutosButton.addActionListener(e -> {
            dispose();
            new ListarProdutos(usuario);
        });
        cadastrarPessoaButton.addActionListener(e -> {
            dispose();
            new CadastrarPessoa(usuario);
        });
    }

    private void criarComponenetes() {
        setContentPane(menu);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
