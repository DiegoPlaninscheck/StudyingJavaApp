package br.sc.senai.produtos.view;

import br.sc.senai.produtos.controller.PessoaController;
import br.sc.senai.produtos.model.entities.Pessoa;

import javax.swing.*;

public class EditarPessoa extends JFrame {
    private JButton editarButton;
    private JTextField inputNome;
    private JTextField inputEmail;
    private JTextField inputSenha;
    private JButton deletarPessoaButton;
    private JButton voltarButton;
    private JPanel editarPessoa;
    private PessoaController pessoaController = new PessoaController();

    public EditarPessoa(Pessoa pessoa, Pessoa pessoaEditar) {
        criarComponentes(pessoaEditar);
        voltarButton.addActionListener(e -> {
            dispose();
            new ListarPessoas(pessoa);
        });
        editarButton.addActionListener(e -> {
            try {
                pessoaController.editarPessoa(pessoaEditar, inputNome.getText(), inputEmail.getText(), inputSenha.getText());
                JOptionPane.showMessageDialog(null, "Pessoa editada com sucesso!");
                dispose();
                new ListarPessoas(pessoa);
            } catch (Exception exception) {
                throw new RuntimeException(exception.getMessage());
            }

        });
        deletarPessoaButton.addActionListener(e -> {
            try {
                pessoaController.deletarPessoa(pessoaEditar);
                JOptionPane.showMessageDialog(null, "Pessoa deletada com sucesso!");
                dispose();
                new ListarPessoas(pessoa);
            } catch (Exception exception) {
                throw new RuntimeException(exception.getMessage());
            }
        });

    }

    private void criarComponentes(Pessoa pessoa) {
        inputEmail.setText(pessoa.getEmailPessoa());
        inputNome.setText(pessoa.getNomePessoa());
        inputSenha.setText(pessoa.getSenhaPessoa());
        setContentPane(editarPessoa);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
