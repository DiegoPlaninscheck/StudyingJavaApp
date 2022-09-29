package br.sc.senai.produtos.view;

import br.sc.senai.produtos.controller.ProdutoController;
import br.sc.senai.produtos.model.entities.Pessoa;

import javax.swing.*;

public class CadastrarProduto extends JFrame {
    private JPanel cadastrarProduto;
    private JTextField inputNome;
    private JTextField inputValor;
    private JTextField inputQuantidade;
    private JButton cadastrarButton;
    private JButton voltarButton;

    private Pessoa usuario;

    public CadastrarProduto(Pessoa pessoa) {
        usuario = pessoa;
        criarComponentes();

        cadastrarButton.addActionListener(e -> {
            ProdutoController produtoController = new ProdutoController();
            try {
                produtoController.cadastrarProduto(inputNome.getText(),
                        Double.parseDouble(inputValor.getText()),
                        Integer.parseInt(inputQuantidade.getText()));
                JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
                dispose();
                new ListarProdutos(usuario);
            }catch (Exception exception){
                throw new RuntimeException(exception.getMessage());
            }
        });

        voltarButton.addActionListener(e -> {
            new ListarProdutos(usuario);
            dispose();
        });

    }

    private void criarComponentes() {
        setContentPane(cadastrarProduto);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
