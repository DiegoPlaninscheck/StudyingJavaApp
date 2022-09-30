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
            int itemSelecionado = tabelaListaPessoas.getSelectedRow();
            if (itemSelecionado != -1) {
                String emailPessoa = (String) tabelaListaPessoas.getValueAt(itemSelecionado, 3);
                Pessoa pessoaParaEditar = pessoaController.selecionarPorEmail(emailPessoa);
                dispose();
                new EditarPessoa(usuario, pessoaParaEditar);
            } else {
                JOptionPane.showMessageDialog(null, "É necessario " +
                        "selecionar uma pessoa para editar");
            }
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
