package br.sc.senai.produtos.model.entities;

public class Pessoa {
    private int numeroPessoa, tipoPessoa;
    private String nomePessoa, cpfPessoa, emailPessoa, senhaPessoa;


    public Pessoa validaLogin(String senha) {
        if (this.getSenhaPessoa().equals(senha)) {
            return this;
        }
        throw new RuntimeException("Senha incorreta!");
    }

    public Pessoa(int numeroPessoa, String nomePessoa, String cpfPessoa, String emailPessoa, String senhaPessoa) {
        this.numeroPessoa = numeroPessoa;
        this.nomePessoa = nomePessoa;
        this.cpfPessoa = cpfPessoa;
        this.emailPessoa = emailPessoa;
        this.senhaPessoa = senhaPessoa;
    }

    public int getNumeroPessoa() {
        return numeroPessoa;
    }

    public void setNumeroPessoa(int numeroPessoa) {
        this.numeroPessoa = numeroPessoa;
    }

    public int getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(int tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getCpfPessoa() {
        return cpfPessoa;
    }

    public void setCpfPessoa(String cpfPessoa) {
        this.cpfPessoa = cpfPessoa;
    }

    public String getEmailPessoa() {
        return emailPessoa;
    }

    public void setEmailPessoa(String emailPessoa) {
        this.emailPessoa = emailPessoa;
    }

    public String getSenhaPessoa() {
        return senhaPessoa;
    }

    public void setSenhaPessoa(String senhaPessoa) {
        this.senhaPessoa = senhaPessoa;
    }
}
