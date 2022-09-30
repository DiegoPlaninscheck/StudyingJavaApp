package br.sc.senai.produtos.view;

import br.sc.senai.produtos.controller.PessoaController;
import br.sc.senai.produtos.model.entities.Cliente;
import br.sc.senai.produtos.model.entities.Funcionario;
import br.sc.senai.produtos.model.entities.Gerente;
import br.sc.senai.produtos.model.entities.Pessoa;

import javax.swing.*;

public class Login extends JFrame implements Runnable {

    PessoaController pessoaController = new PessoaController();

    private JTextField inputEmail;
    private JPasswordField inputSenha;
    private JButton botaoLogin;
    private JPanel login;

    public Login() {
        criarComponentes();
        botaoLogin.addActionListener(e -> {
            try {
                Pessoa pessoa = pessoaController.validaLogin(inputEmail.getText(), inputSenha.getText());
                dispose();
                if(pessoa instanceof Cliente){
                    new ListarProdutos(pessoa);
                } else if(pessoa instanceof Funcionario || pessoa instanceof Gerente){
                    new Menu(pessoa);
                }
            } catch (RuntimeException err) {
                JOptionPane.showMessageDialog(null, err.getMessage());
            }
        });
    }

    private void criarComponentes() {
        setContentPane(login);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        run();
        pack();
    }

    @Override
    public void run() {
        if (!isVisible()) {
            setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "A janela ja esta aberta");
        }
    }

    public static void main(String[] args) {
        Login login = new Login();
    }
}
