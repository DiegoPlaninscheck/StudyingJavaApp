package br.sc.senai.produtos.view;

import br.sc.senai.produtos.controller.ProdutoController;
import br.sc.senai.produtos.model.entities.*;

import javax.swing.*;

public class ListarProdutos extends JFrame {
    private JTable tabelaProdutos;
    private JButton voltarButton;
    private JButton cadastrarProdutoButton;
    private JButton comprarProdutoButton;
    private JPanel listaProdutos;

    private Pessoa usuario;
    private ProdutoController produtoController = new ProdutoController();

    public ListarProdutos(Pessoa pessoa) {
        usuario = pessoa;
        criarComponentes();

        voltarButton.addActionListener(e -> {
            dispose();
            if (usuario instanceof Cliente) {
                new Login();
            } else {
                new Menu(usuario);
            }
        });
        cadastrarProdutoButton.addActionListener(e -> {
            dispose();
            new CadastrarProduto(usuario);
        });
        comprarProdutoButton.addActionListener(e -> {
            int itemSelecionado = tabelaProdutos.getSelectedRow();
            if (itemSelecionado != -1) {
                int idProduto = (Integer) tabelaProdutos.getValueAt(itemSelecionado, 0);
                Produto produto = produtoController.selecionarProdutoPorId(idProduto);
                int qtdProdutoVenda = Integer.parseInt(
                        JOptionPane.showInputDialog(null, "Quantidade que deseja comprar"));
                try {
                    produtoController.venderProduto(produto, qtdProdutoVenda);
                    JOptionPane.showMessageDialog(null, "Produto vendido com sucesso!");
                    criarComponentes();
                } catch (Exception exception) {
                    throw new RuntimeException(exception.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "É necessario selecionar um item para comprar!");
            }
        });
    }

    private void criarComponentes() {

        if (usuario instanceof Funcionario || usuario instanceof Gerente) {
            comprarProdutoButton.setVisible(false);
        }
        if (usuario instanceof Cliente) {
            cadastrarProdutoButton.setVisible(false);
        }

        tabelaProdutos.setModel(new DefaultTableModelArrayListProdutos(produtoController.selecionarTodosProdutos()));

        setContentPane(listaProdutos);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
