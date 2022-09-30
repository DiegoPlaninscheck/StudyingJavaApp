package br.sc.senai.produtos.view;

import br.sc.senai.produtos.controller.PessoaController;
import br.sc.senai.produtos.model.entities.Pessoa;

import javax.swing.*;

public class ListarPessoas extends JFrame {
    private JTable tabelaListaPessoas;
    private JButton editarPessoaButton;
    private JButton voltarButton;
    private JPanel listaPessoas;
    private PessoaController pessoaController = new PessoaController();
    private Pessoa usuario;

    public ListarPessoas(Pessoa pessoa) {
        usuario = pessoa;
        criarComponentes();
        voltarButton.addActionListener(e -> {
            dispose();
            new Menu(usuario);
        });
        editarPessoaButton.addActionListener(e -> {

        });
    }

    private void criarComponentes() {

        tabelaListaPessoas.setModel(new DefaultTableModelArrayListPessoas(pessoaController.selecionarTodasPessoas()));

        setContentPane(listaPessoas);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
