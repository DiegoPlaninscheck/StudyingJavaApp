package br.sc.senai.produtos.model.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoFactory {
    private String url = "jdbc:mysql://localhost:3306/javaprodutos";
    private String username = "root";
    private String password = "root";

    public Connection conectaBD() {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            throw new RuntimeException("Erro na conexao");
        }
    }

}
