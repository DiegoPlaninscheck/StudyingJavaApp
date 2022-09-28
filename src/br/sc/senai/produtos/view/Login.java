package br.sc.senai.produtos.view;

import javax.swing.*;

public class Login extends JFrame implements Runnable{



    private JTextField inputUsuario;
    private JPasswordField inputSenha;
    private JButton botaoLogin;
    private JPanel login;

    public Login(){
        criarComponentes();
    }

    private void criarComponentes() {
        setContentPane(login);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        run();
        pack();
    }

    @Override
    public void run(){
        if(!isVisible()){
            setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "A janela ja esta aberta");
        }
    }

    public static void main(String[] args) {
        Login login = new Login();
    }
}
