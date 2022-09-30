package br.sc.senai.produtos.model.dao;

import br.sc.senai.produtos.model.entities.Pessoa;
import br.sc.senai.produtos.model.factory.ConexaoFactory;
import br.sc.senai.produtos.model.factory.PessoaFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PessoaDAO {

    private Connection connection;

    public PessoaDAO() {
        this.connection = new ConexaoFactory().conectaBD();
    }

    public Pessoa buscarPorEmail(String email) {
        String sqlComando = "select * from pessoa where emailPessoa = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlComando)) {
            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return extrairObjeto(resultSet);
                }
            } catch (Exception e) {
                throw new RuntimeException("Erro na execução do comando SQL");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro na preparação do comando SQL");
        }
        throw new RuntimeException("Algo deu ruim");
    }

    private Pessoa extrairObjeto(ResultSet resultSet) {
        try {
            return new PessoaFactory().getPessoa(resultSet.getInt("idPessoa"),
                    resultSet.getInt("tipoPessoa"),
                    resultSet.getString("nomePessoa"),
                    resultSet.getString("cpfPessoa"),
                    resultSet.getString("emailPessoa"),
                    resultSet.getString("senhaPessoa"));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao extrair objeto");
        }
    }

    public void cadastrarPessoa(String nomePessoa, String cpfPessoa, String emailPessoa, String senhaPessoa, int tipoPessoa) {
        String sqlComando = "insert into pessoa " +
                "(nomePessoa, emailPessoa, cpfPessoa, senhaPessoa, tipoPessoa) values (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlComando)) {
            preparedStatement.setString(1, nomePessoa);
            preparedStatement.setString(2, emailPessoa);
            preparedStatement.setString(3, cpfPessoa);
            preparedStatement.setString(4, senhaPessoa);
            preparedStatement.setInt(5, tipoPessoa);
            try {
                preparedStatement.execute();
            } catch (Exception e) {
                throw new RuntimeException("Erro na execução do comando SQL");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro na preparação do comando SQL");
        }
    }
}
