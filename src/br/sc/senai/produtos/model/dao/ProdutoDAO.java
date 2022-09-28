package br.sc.senai.produtos.model.dao;

import br.sc.senai.produtos.model.entities.Produto;
import br.sc.senai.produtos.model.factory.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

public class ProdutoDAO {

    Connection connection;

    public ProdutoDAO() {
        this.connection = new ConexaoFactory().conectaBD();
    }


    public Collection<Produto> selecionarTodosProdutos() {
        Collection<Produto> listaProdutos = new ArrayList<>();
        String sqlComando = "select * from produto";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlComando)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    listaProdutos.add(extrairObjeto(resultSet));
                }
            } catch (Exception e) {
                throw new RuntimeException("Erro na execução do comando SQL");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro na preparação do comando SQL");
        }
        throw new RuntimeException("Algo deu ruim");
    }

    private Produto extrairObjeto(ResultSet resultSet) {
        try {
            return new Produto(resultSet.getInt("idProduto"),
                    resultSet.getInt("qtdEstoque"),
                    resultSet.getDouble("valorProduto"),
                    resultSet.getString("nomeProduto"));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao extrair objeto!");
        }
    }
}
